# WEEK 10: Input Validation, Java 8 Essentials & JWT Security - Starter Template

## 📚 Deskripsi Project
Template starter project untuk pembelajaran Week 10 yang mencakup:
- **Input Validation**: Menggunakan Jakarta Bean Validation (@Valid, @NotBlank, @Min, dll)
- **Java 8 Essentials**: Optional<T> dan Lambda Expression () ->
- **Global Exception Handling**: @RestControllerAdvice untuk menangani error secara terpusat
- **JWT Authentication**: Spring Security + JWT Token untuk stateless authentication

---

## 🚀 Memulai

### STEP 1: Clone Repository
```bash
git clone https://github.com/riskiana-academy/spring-catalog-api.git
cd spring-catalog-api
```

### STEP 2: Setup Database
Database akan otomatis dibuat saat aplikasi startup dengan parameter `?createDatabaseIfNotExist=true`

**Optional - Manual setup:**
```bash
mysql -u root -p
> CREATE DATABASE catalog_db;
```

### STEP 3: Update application.properties (Jika diperlukan)
File: `src/main/resources/application.properties`

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/catalog_db?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=    # Isi password MySQL Anda (jika ada)
```

### STEP 4: Build & Run
```bash
# Menggunakan Maven
mvn clean install
mvn spring-boot:run

# Atau menggunakan IDE (VS Code, IntelliJ) → Run Application.java
```

Server berjalan di: `http://localhost:8080`

---

## 🏗️ Struktur Project

```
src/main/java/com/budiluhur/spring/catalog/api/
├── Application.java                 # Spring Boot Main Class
├── controller/
│   ├── AuthController.java          # POST /api/auth/login
│   └── ProductController.java       # GET, POST /api/products
├── service/
│   └── ProductService.java          # Business logic (Optional + Lambda)
├── model/
│   └── Product.java                 # JPA Entity
├── repository/
│   └── ProductRepository.java       # JPA Repository
├── dto/
│   ├── ProductCreateRequest.java   # Request DTO (dengan validasi)
│   ├── LoginRequest.java           # Login DTO
│   └── AuthResponse.java           # Response DTO
├── exception/
│   ├── ResourceNotFoundException.java # Custom Exception
│   └── GlobalExceptionHandler.java   # Global Exception Handler
└── config/
    ├── SecurityConfig.java          # Spring Security Configuration
    └── JwtUtils.java               # JWT Token Generator
```

---

## 📋 ASSIGNMENT: 4 Steps untuk Mahasiswa

> **👉 Baca file [LAB_GUIDE.md](./LAB_GUIDE.md) untuk instruksi detail!**

Mahasiswa perlu mengimplementasikan 4 step berikut:

### **STEP 1: Tambahkan Validasi Annotations pada ProductCreateRequest.java**
- File: `src/main/java/com/budiluhur/spring/catalog/api/dto/ProductCreateRequest.java`
- Task: Tambahkan `@NotBlank`, `@NotNull`, `@Min` annotations pada setiap field
- Lihat: **LAB_GUIDE.md → PART 1**

### **STEP 2: Pasang @Valid Annotation di ProductController**
- File: `src/main/java/com/budiluhur/spring/catalog/api/controller/ProductController.java`
- Task: Tambahkan `@Valid` pada `@RequestBody ProductCreateRequest request` di method `createProduct()`
- Lihat: **LAB_GUIDE.md → PART 1**

### **STEP 3: Buat Global Exception Handler**
- File: `src/main/java/com/budiluhur/spring/catalog/api/exception/GlobalExceptionHandler.java`
- Task: Buat class baru dengan `@RestControllerAdvice` dan `@ExceptionHandler` untuk handle validation errors
- Lihat: **LAB_GUIDE.md → PART 1**

### **STEP 4: Testing via Postman**
- Test Login JWT
- Test Input Valid → Expected 201 Created
- Test Input Invalid (empty fields) → Expected 400 Bad Request
- Test ID tidak ada → Expected 404 Not Found
- Lihat: **LAB_GUIDE.md → POSTMAN Testing Checklist**

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

Response (200 OK):
[
  {
    "id": "PROD001",
    "name": "Laptop",
    "price": 15000000.0
  }
]
```

### 3. Get Product by ID
```http
GET /api/products/PROD001

Response (200 OK):
{
  "id": "PROD001",
  "name": "Laptop",
  "price": 15000000.0
}

Response (404 Not Found):
{
  "error": "Produk dengan ID 'PROD001' tidak ditemukan!"
}
```

### 4. Create New Product
```http
POST /api/products
Content-Type: application/json

{
  "id": "PROD002",
  "name": "Mouse",
  "price": 150000.0
}

Response (201 Created):
{
  "id": "PROD002",
  "name": "Mouse",
  "price": 150000.0
}

Response (400 Bad Request - Validasi Gagal):
{
  "id": "ID produk wajib diisi",
  "name": "Nama produk tidak boleh kosong",
  "price": "Harga minimal Rp 1.000"
}
```

---

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

---

## 🎓 Learning Outcomes

Setelah menyelesaikan assignment ini, mahasiswa akan memahami:
- ✅ Jakarta Bean Validation dan cara menggunakan `@Valid`
- ✅ Java 8 Optional + Lambda Expression untuk null-safe programming
- ✅ Global Exception Handling dengan `@RestControllerAdvice`
- ✅ JWT Authentication dan stateless security
- ✅ Best practices dalam API design dan error handling

---

## 📖 Referensi Lengkap

👉 **[LAB_GUIDE.md](./LAB_GUIDE.md)** - Instruksi detail 4 steps assignment
👉 **[HELP.md](./HELP.md)** - Troubleshooting & FAQ

---

**Happy Coding! 🚀**

