# WEEK 10 - Lab Guide: Input Validation, Java 8 & JWT Security

## Tujuan Lab
1. ✅ Memahami dan mengimplementasikan Input Validation dengan Jakarta Bean Validation
2. ✅ Menggunakan Java 8 Optional + Lambda Expression untuk null-safe programming
3. ✅ Implementasi Global Exception Handling dengan @RestControllerAdvice
4. ✅ Memahami konsep stateless authentication menggunakan JWT
5. ✅ Testing API dengan Postman/Thunder Client

---

## PART 1: Input Validation & Exception Handling 

### 1.1 Memahami Bean Validation

**Problem tanpa validation:**
```java
// Controller  tanpa validasi
@PostMapping
public Product createProduct(@RequestBody ProductCreateRequest request) {
    // Bagaimana jika id kosong? name null? price negatif?
    // Harus validasi manual di dalam method
}
```

**Solution dengan @Valid + Annotations:**

#### Step 1: Lihat ProductCreateRequest.java


#### Step 2: Gunakan @Valid di Controller

#### Step 3: Spring otomatis akan validate & throw MethodArgumentNotValidException

### 1.2 Global Exception Handling

**File: `exception/GlobalExceptionHandler.java`**

Saat validasi gagal, Spring akan melempar exception, kemudian GlobalExceptionHandler akan menangkap:

```java
@ExceptionHandler(MethodArgumentNotValidException.class)
public ResponseEntity<Map<String, String>> handleValidation(MethodArgumentNotValidException ex) {
    Map<String, String> errors = new HashMap<>();
    
    // Menggunakan Java 8 forEach Lambda
    ex.getBindingResult().getFieldErrors().forEach(err ->
        errors.put(err.getField(), err.getDefaultMessage())
    );
    
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
}
```

**Result: Response yang rapi (bukan whitelabel error):**
```json
{
  "id": "ID produk wajib diisi",
  "name": "Nama produk tidak boleh kosong",
  "price": "Harga minimal Rp 1.000"
}
```

### 1.3 Activity: Test Validation

**Gunakan Postman untuk POST dengan data invalid:**

```json
{
  "id": "",
  "name": "",
  "price": 500
}
```

**Expected Response (400 Bad Request):**
```json
{
  "id": "ID produk wajib diisi",
  "name": "Nama produk tidak boleh kosong",
  "price": "Harga minimal Rp 1.000"
}
```

---

## PART 2: Java 8 Optional + Lambda 

### 2.1 Problem: NullPointerException

**Kode lama yang rawan error:**
```java
public Product getProductById(String id) {
    Optional<Product> product = productRepository.findById(id);
    if (product.isPresent()) {
        return product.get();
    } else {
        throw new ResourceNotFoundException("Produk tidak ditemukan");
    }
}
```

### 2.2 Solution: Optional + orElseThrow() + Lambda

**Lihat: `service/ProductService.java`**

```java
public Product getProductById(String id) {
    // Menggunakan Java 8 Optional + Lambda () ->
    return productRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException(
                "Produk dengan ID '" + id + "' tidak ditemukan!"
            ));
}
```

**Penjelasan:**
- `.findById(id)` mengembalikan `Optional<Product>`
- `.orElseThrow(() -> ...)` adalah lambda yang throw exception jika kosong
- Lebih rapi, type-safe, dan aman dari null

### 2.3 Variasi Optional Methods

```java
// 1. orElseThrow - Throw exception jika tidak ada
productRepository.findById(id)
    .orElseThrow(() -> new Exception("Not found"));

// 2. orElse - Return default value jika tidak ada
Product product = productRepository.findById(id)
    .orElse(new Product());

// 3. ifPresent - Execute action jika ada
productRepository.findById(id)
    .ifPresent(product -> System.out.println(product.getName()));

// 4. ifPresentOrElse - Conditional logic
productRepository.findById(id)
    .ifPresentOrElse(
        product -> System.out.println("Found: " + product.getName()),
        () -> System.out.println("Not found")
    );
```

### 2.4 Activity: Test dengan ID yang tidak ada

**GET** `/api/products/INVALID_ID`

**Expected Response (404 Not Found):**
```json
{
  "error": "Produk dengan ID 'INVALID_ID' tidak ditemukan!"
}
```

---

## PART 3: JWT Authentication 

### 3.1 Konsep JWT

**Analogi Tiket Konser:**
1. Mahasiswa datang ke loket dengan KTP/NIM
2. Loket (Server) memverifikasi identitas
3. Loket memberikan Gelang Tiket (JWT Token)
4. Mahasiswa masuk area dengan menunjukkan gelang tiket
5. Security hanya perlu lihat gelang, tidak perlu lihat KTP lagi

**JWT Format:**
```
header.payload.signature

Contoh:
eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTcwMDY0MDAwMCwiZXhwIjoxNzAwNzI2NDAwfQ.9x5aZ...
```

### 3.2 Alur Login & Generate Token

**File: `config/JwtUtils.java`**
```java
public String generateToken(String username) {
    return Jwts.builder()
            .setSubject(username)                    // Username: "admin"
            .setIssuedAt(new Date())                 // Waktu buat token
            .setExpiration(new Date(...))            // Waktu expire (24 jam)
            .signWith(key)                           // Sign dengan secret key
            .compact();                              // Convert ke string
}
```

**File: `controller/AuthController.java`**
```java
@PostMapping("/login")
public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
    if ("admin".equals(request.getUsername()) && 
        "password123".equals(request.getPassword())) {
        String token = jwtUtils.generateToken(request.getUsername());
        return ResponseEntity.ok(new AuthResponse(token));
    }
    return ResponseEntity.status(401).body(null);
}
```

### 3.3 Activity: Test Login Flow

#### Step 1: Login untuk mendapatkan token
```bash
POST /api/auth/login
Content-Type: application/json

{
  "username": "admin",
  "password": "password123"
}
```

**Response:**
```json
{
  "token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTcwMDY0MDAwMCwiZXhwIjoxNzAwNzI2NDAwfQ.9x5aZ...",
  "tokenType": "Bearer"
}
```

#### Step 2: Copy token

#### Step 3: Gunakan token untuk akses protected endpoint
```bash
GET /api/products
Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTcwMDY0MDAwMCwiZXhwIjoxNzAwNzI2NDAwfQ.9x5aZ...
```

### 3.4 Security Configuration

**File: `config/SecurityConfig.java`**

```java
@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())              // Disable CSRF untuk REST API
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/auth/**").permitAll()  // Public
                .anyRequest().permitAll()                     // Sementara public
            );
        return http.build();
    }
}
```

**Penjelasan:**
- `.csrf(csrf -> csrf.disable())` - Matikan CSRF (REST API tidak butuh)
- `.requestMatchers("/api/auth/**").permitAll()` - Login endpoint boleh diakses siapa saja
- `.anyRequest().permitAll()` - Sementara endpoint lain juga public (untuk kemudahan lab)

### 3.5 Upgrade: Private Endpoint

**Untuk membuat endpoint private (perlu token), ubah baris terakhir:**

```java
.authorizeHttpRequests(auth -> auth
    .requestMatchers("/api/auth/**").permitAll()      // Login public
    .requestMatchers("/api/products/**").authenticated() // Products perlu login
)
```

---

## POSTMAN Testing Checklist

### ✅ Checklist Lengkap

```
[ ] 1. POST /api/auth/login
      - Credentials: admin / password123
      - Expected: 200 OK dengan token

[ ] 2. POST /api/products (Valid)
      - Body: { "id": "PROD001", "name": "Laptop", "price": 15000000 }
      - Expected: 201 Created

[ ] 3. POST /api/products (Invalid - Empty Fields)
      - Body: { "id": "", "name": "", "price": 0 }
      - Expected: 400 Bad Request dengan error messages

[ ] 4. POST /api/products (Invalid - Price Too Low)
      - Body: { "id": "PROD002", "name": "Mouse", "price": 500 }
      - Expected: 400 Bad Request

[ ] 5. GET /api/products
      - Expected: 200 OK dengan list semua products

[ ] 6. GET /api/products/PROD001
      - Expected: 200 OK dengan detail product

[ ] 7. GET /api/products/INVALID_ID
      - Expected: 404 Not Found dengan error message

[ ] 8. GET /api/products (dengan invalid token)
      - Authorization: Bearer invalid_token
      - Expected: 401 Unauthorized (jika sudah implement JWT filter)
```

---

## 🎯 Troubleshooting

### Error: "Database tidak terkoneksi"
```bash
# 1. Pastikan MySQL running
# 2. Create database
mysql -u root -p
> CREATE DATABASE catalog_db;

# 3. Update application.properties dengan credentials yang benar
```

### Error: "Validation annotation tidak bekerja"
```bash
# Pastikan dependency sudah ada di pom.xml:
# spring-boot-starter-validation
```

### Error: "JWT library tidak ditemukan"
```bash
# Pastikan JJWT dependencies ada di pom.xml:
# jjwt-api, jjwt-impl, jjwt-jackson (versi 0.11.5)
```

---

## 📌 Ringkasan Konsep

| Konsep | File | Fungsi |
|--------|------|--------|
| **Bean Validation** | ProductCreateRequest.java | Deklaratif validation dengan annotations |
| **Global Exception** | GlobalExceptionHandler.java | Tangkap error dan return JSON response |
| **Optional + Lambda** | ProductService.java | Null-safe programming dengan Java 8 |
| **JWT Token** | JwtUtils.java | Generate & manage JWT tokens |
| **Security Config** | SecurityConfig.java | Configure Spring Security rules |

---

