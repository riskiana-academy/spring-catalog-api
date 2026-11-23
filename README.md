# WEEK 10: Input Validation, Java 8 Essentials & JWT Security - Starter Template

## 📚 Deskripsi Project
Template starter project untuk pembelajaran Week 10 yang mencakup:
- **Input Validation**: Menggunakan Jakarta Bean Validation (@Valid, @NotBlank, @Min, dll)
- **Java 8 Essentials**: Optional<T> dan Lambda Expression () ->
- **Global Exception Handling**: @RestControllerAdvice untuk menangani error secara terpusat
- **JWT Authentication**: Spring Security + JWT Token untuk stateless authentication

## 🏗️ Struktur Project

```
src/main/java/com/budiluhur/spring/catalog/api/
├── Application.java                 # Spring Boot Main Class
├── controller/
│   ├── AuthController.java          # Endpoint: POST /api/auth/login
│   └── ProductController.java       # Endpoints: GET, POST products
├── service/
│   └── ProductService.java          # Business logic dengan Optional + Lambda
├── model/
│   └── Product.java                 # JPA Entity
├── repository/
│   └── ProductRepository.java       # JPA Repository
├── dto/
│   ├── ProductCreateRequest.java   # Request DTO dengan validasi
│   ├── LoginRequest.java           # Login DTO
│   └── AuthResponse.java           # Response DTO
├── exception/
│   ├── ResourceNotFoundException.java # Custom Exception
│   └── GlobalExceptionHandler.java   # Centralized Exception Handler
└── config/
    ├── SecurityConfig.java          # Spring Security Configuration
    └── JwtUtils.java               # JWT Token Generator
```

## 🚀 Cara Menggunakan Template Ini

### 1. Setup Database
✅ **NEW FEATURE:** Database akan otomatis dibuat!

**Option A (Recommended):**
```bash
# Database akan auto-create saat aplikasi startup
# Tidak perlu manual CREATE DATABASE
# Karena parameter: ?createDatabaseIfNotExist=true
```

**Option B (Manual):**
```bash
# Buat database MySQL
CREATE DATABASE catalog_db;
```

Atau gunakan command line MySQL:
```bash
mysql -u root -p
> CREATE DATABASE catalog_db;
> EXIT;
```

### 2. Update application.properties (Jika diperlukan)
File: `src/main/resources/application.properties`

Sesuaikan konfigurasi database:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/catalog_db?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=    # Isi password MySQL Anda (jika ada)
```

**Penjelasan parameter:**
- `createDatabaseIfNotExist=true` → Database auto-dibuat jika belum ada
- Sangat praktis untuk development & learning!

### 3. Build & Run Project
```bash
# Menggunakan Maven
mvn clean install
mvn spring-boot:run

# Atau gunakan IDE (VS Code, IntelliJ) untuk run Application.java
```

Server akan berjalan di: `http://localhost:8080`

## 📝 API Endpoints

### 1. Login (Generate JWT Token)
```http
POST /api/auth/login
Content-Type: application/json

{
  "username": "admin",
  "password": "password123"
}

Response (200 OK):
{
  "token": "eyJhbGciOiJIUzI1NiJ9...",
  "tokenType": "Bearer"
}
```

### 2. Get All Products
```http
GET /api/products
Accept: application/json

Response (200 OK):
[
  {
    "id": "PROD001",
    "name": "Laptop",
    "price": 15000000.0
  },
  ...
]
```

### 3. Get Product by ID
```http
GET /api/products/{id}

Response (200 OK):
{
  "id": "PROD001",
  "name": "Laptop",
  "price": 15000000.0
}

Response (404 Not Found):
{
  "error": "Produk dengan ID 'PROD999' tidak ditemukan!"
}
```

### 4. Create New Product (dengan Validation)
```http
POST /api/products
Content-Type: application/json

{
  "id": "PROD001",
  "name": "Laptop Gaming",
  "price": 15000000.0
}

Response (201 Created):
{
  "id": "PROD001",
  "name": "Laptop Gaming",
  "price": 15000000.0
}

Response (400 Bad Request - Validasi Gagal):
{
  "id": "ID produk wajib diisi",
  "name": "Nama produk tidak boleh kosong",
  "price": "Harga minimal Rp 1.000"
}
```

## 🔍 Fitur-Fitur Utama yang Sudah Diimplementasi

### 1. Input Validation (@Valid)
Lihat: `dto/ProductCreateRequest.java`

```java
@NotBlank(message = "ID produk wajib diisi")
private String id;

@NotBlank(message = "Nama produk tidak boleh kosong")
private String name;

@NotNull(message = "Harga produk wajib diisi")
@Min(value = 1000, message = "Harga minimal Rp 1.000")
private Double price;
```

Gunakan `@Valid` di Controller:
```java
@PostMapping
public ResponseEntity<Product> createProduct(@Valid @RequestBody ProductCreateRequest request) {
    // ...
}
```

### 2. Java 8 Optional + Lambda
Lihat: `service/ProductService.java`

```java
public Product getProductById(String id) {
    // Menggunakan Java 8 Optional + Lambda () ->
    return productRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException(
                "Produk dengan ID '" + id + "' tidak ditemukan!"
            ));
}
```

### 3. Global Exception Handling
Lihat: `exception/GlobalExceptionHandler.java`

```java
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidation(...) {
        // Menangani error validasi otomatis
    }
    
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleNotFound(...) {
        // Menangani custom exception
    }
}
```

### 4. JWT Authentication
Lihat: `config/JwtUtils.java` dan `config/SecurityConfig.java`

**Generate Token:**
```java
String token = jwtUtils.generateToken(username);
```

**Security Configuration:**
- `/api/auth/**` → Public (tidak perlu token)
- `/api/products/**` → Sementara Public (untuk kemudahan lab)
- Dapat diupdate ke private dengan menambahkan JWT filter

## 📚 Referensi Validation Annotations

| Annotation | Fungsi | Contoh |
|-----------|--------|---------|
| `@NotBlank` | String tidak boleh kosong | `@NotBlank(message = "...")` |
| `@NotNull` | Value tidak boleh null | `@NotNull` |
| `@Min` | Minimal value untuk Number | `@Min(value = 1000)` |
| `@Max` | Maximal value untuk Number | `@Max(value = 999999999)` |
| `@Size` | Ukuran String/Collection | `@Size(min=5, max=50)` |
| `@Email` | Format email valid | `@Email` |
| `@Pattern` | Regex pattern | `@Pattern(regexp = "^[A-Z].*")` |

## 🧪 Testing dengan Postman

### Import Environment
Buat environment dengan variable:
```
{
  "token": "<<copy-paste token dari login response>>",
  "baseUrl": "http://localhost:8080"
}
```

### Test Sequence
1. **Login** → Copy token
2. **Create Product** → Buat data baru
3. **Get All Products** → Lihat semua data
4. **Get Product by ID** → Detail satu produk
5. **Create dengan Validasi Error** → Kirim data tidak valid, lihat response error

## 🎓 Learning Outcomes

Setelah menggunakan template ini, mahasiswa akan memahami:
✅ Bagaimana menggunakan Jakarta Bean Validation (@Valid, @NotBlank, dll)  
✅ Cara menggunakan Java 8 Optional + Lambda untuk menangani null safely  
✅ Implementasi Global Exception Handling dengan @RestControllerAdvice  
✅ Konsep JWT dan Stateless Authentication  
✅ Best practices dalam API design dan error handling  

