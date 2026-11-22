# 🚀 QUICK START - Week 10 Starter Template

## ⚡ 5 Menit Setup

### 1. Database Setup (1 menit)
```bash
# Buka MySQL Command Line atau MySQL Workbench
mysql -u root -p
```

```sql
CREATE DATABASE catalog_db;
EXIT;
```

### 2. Update Database Credentials (1 menit)
**File:** `src/main/resources/application.properties`

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/catalog_db
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD_HERE
```

### 3. Run Project (2 menit)
```bash
# Terminal / Command Prompt
mvn clean install
mvn spring-boot:run
```

**Atau di VS Code:**
1. Open Application.java
2. Click "Run" atau press `F5`

**Atau di IntelliJ:**
1. Right-click Application.java
2. Select "Run 'Application.main()'"

**Output yang diharapkan:**
```
...
Tomcat started on port(s): 8080 (http)
Application started successfully!
```

### 4. Test dengan Postman (1 menit)

**Import collection atau buat manual:**

#### Request 1: Login
```
POST http://localhost:8080/api/auth/login
Content-Type: application/json

{
  "username": "admin",
  "password": "password123"
}
```

#### Request 2: Create Product
```
POST http://localhost:8080/api/products
Content-Type: application/json

{
  "id": "PROD001",
  "name": "Laptop Gaming",
  "price": 15000000.0
}
```

#### Request 3: Get All Products
```
GET http://localhost:8080/api/products
```

**🎉 Setup Selesai!**

---

## 📂 File Structure

```
spring.catalog.api/
├── pom.xml                              # Maven dependencies ✅
├── README.md                            # Dokumentasi lengkap
├── LAB_GUIDE.md                         # Panduan lab detail
├── QUICK_START.md                       # File ini
│
├── src/main/java/.../api/
│   ├── Application.java                 # Main class
│   ├── controller/
│   │   ├── AuthController.java          # POST /api/auth/login
│   │   └── ProductController.java       # GET/POST /api/products
│   ├── service/
│   │   └── ProductService.java          # Business logic (Optional + Lambda)
│   ├── model/
│   │   └── Product.java                 # JPA Entity (@Entity)
│   ├── repository/
│   │   └── ProductRepository.java       # JPA Repository
│   ├── dto/
│   │   ├── ProductCreateRequest.java    # @Valid + Validation
│   │   ├── LoginRequest.java
│   │   └── AuthResponse.java
│   ├── exception/
│   │   ├── ResourceNotFoundException.java
│   │   └── GlobalExceptionHandler.java  # @RestControllerAdvice
│   └── config/
│       ├── JwtUtils.java               # JWT Token generator
│       └── SecurityConfig.java         # Spring Security config
│
└── src/main/resources/
    └── application.properties            # Database config
```

---

## 🔑 Key Concepts

### 1️⃣ Input Validation (@Valid)
```java
@NotBlank(message = "ID produk wajib diisi")
private String id;

@Min(value = 1000, message = "Harga minimal Rp 1.000")
private Double price;
```
→ **Lihat:** ProductCreateRequest.java

### 2️⃣ Exception Handling (@RestControllerAdvice)
```java
@ExceptionHandler(MethodArgumentNotValidException.class)
public ResponseEntity<Map<String, String>> handleValidation(...) {
    // Return JSON dengan error messages
}
```
→ **Lihat:** GlobalExceptionHandler.java

### 3️⃣ Optional + Lambda (Java 8)
```java
return productRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException(...));
```
→ **Lihat:** ProductService.java

### 4️⃣ JWT Authentication
```java
String token = jwtUtils.generateToken(username);
return ResponseEntity.ok(new AuthResponse(token));
```
→ **Lihat:** AuthController.java, JwtUtils.java

---

## 📝 Endpoints Summary

| Method | Endpoint | Deskripsi | Auth? |
|--------|----------|-----------|-------|
| POST | `/api/auth/login` | Generate JWT token | ❌ |
| GET | `/api/products` | List semua products | ⭕ |
| GET | `/api/products/{id}` | Get product by ID | ⭕ |
| POST | `/api/products` | Create product (dengan validation) | ⭕ |

> ⭕ = Sementara public (bisa diubah ke private)

---

## 🧪 Testing

### Validation Error Test
```json
POST /api/products
{
  "id": "",
  "name": "",
  "price": 500
}

Expected Response (400):
{
  "id": "ID produk wajib diisi",
  "name": "Nama produk tidak boleh kosong",
  "price": "Harga minimal Rp 1.000"
}
```

### Not Found Error Test
```json
GET /api/products/INVALID_ID

Expected Response (404):
{
  "error": "Produk dengan ID 'INVALID_ID' tidak ditemukan!"
}
```

---

## ⚙️ Configuration

### Database Config
**File:** `src/main/resources/application.properties`
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/catalog_db
spring.datasource.username=root
spring.datasource.password=PASSWORD
```

### Server Port
```properties
server.port=8080
```

### JPA/Hibernate
```properties
spring.jpa.hibernate.ddl-auto=update  # Auto create tables
spring.jpa.show-sql=false            # Jangan print SQL di console
```

---

## 🆘 Common Issues & Fix

### ❌ "Connection refused" (Database error)
✅ **Fix:** 
- Pastikan MySQL running
- Buat database: `CREATE DATABASE catalog_db;`
- Update credentials di application.properties

### ❌ "No validators found" (Validation tidak bekerja)
✅ **Fix:**
- Pastikan `spring-boot-starter-validation` di pom.xml
- Jalankan `mvn clean install`

### ❌ "JWT library not found"
✅ **Fix:**
- Pastikan JJWT dependencies di pom.xml (versi 0.11.5)
- Run `mvn clean install`

### ❌ Port 8080 sudah digunakan
✅ **Fix:**
- Change di `application.properties`: `server.port=8081`

---

## 📚 Dokumentasi Lengkap

- **README.md** - Dokumentasi komprehensif
- **LAB_GUIDE.md** - Panduan lab step-by-step
- **WEEK 10.docx** - Materi pembelajaran dari dosen

---

## 🎓 Learning Path

```
1. Run aplikasi & test endpoints
   ↓
2. Lihat ProductCreateRequest.java (validation)
   ↓
3. Lihat GlobalExceptionHandler.java (exception handling)
   ↓
4. Lihat ProductService.java (Optional + Lambda)
   ↓
5. Lihat AuthController.java & JwtUtils.java (JWT)
   ↓
6. Modifikasi & tambah fitur sendiri!
```

---

## ✅ Checklist Sebelum Submit

- [ ] Database sudah dibuat
- [ ] Aplikasi bisa run tanpa error
- [ ] POST /api/auth/login → 200 OK
- [ ] POST /api/products (valid) → 201 Created
- [ ] POST /api/products (invalid) → 400 Bad Request
- [ ] GET /api/products → 200 OK
- [ ] GET /api/products/{id} → 200 OK
- [ ] GET /api/products/INVALID → 404 Not Found

---

**🚀 Ready to Code? Let's Go!**

Jika ada pertanyaan, lihat README.md atau LAB_GUIDE.md yang lebih detail.
