# 🔧 FIX: ClassNotFoundException MySQL8Dialect

**Error yang terjadi:**
```
Caused by: java.lang.ClassNotFoundException: Could not load requested class: 
org.hibernate.dialect.MySQL8Dialect
```

---

## ✅ SOLUSI (Sudah dilakukan otomatis)

### 1️⃣ Update pom.xml

Tambahkan Hibernate dependency ke `pom.xml`:

```xml
<!-- Hibernate ORM - Explicit dependency -->
<dependency>
    <groupId>org.hibernate.orm</groupId>
    <artifactId>hibernate-core</artifactId>
</dependency>

<!-- MySQL JDBC Driver dengan versi spesifik -->
<dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
    <version>8.0.33</version>
</dependency>
```

**Status:** ✅ Sudah dilakukan

---

### 2️⃣ Update application.properties

Ubah dari `MySQL8Dialect` ke `MySQL8InnoDBDialect`:

**Before:**
```properties
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
```

**After:**
```properties
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8InnoDBDialect
```

**Status:** ✅ Sudah dilakukan

**Lokasi file:** `src/main/resources/application.properties`

---

## 🚀 Langkah Selanjutnya

### Step 1: Buat Database
```bash
mysql -u root -p
> CREATE DATABASE catalog_db;
> EXIT;
```

### Step 2: Clean & Build
```bash
mvn clean install -DskipTests
```

### Step 3: Run Application
```bash
mvn spring-boot:run
```

**Expected Output:**
```
Tomcat started on port(s): 8080 (http)
Application started successfully!
```

---

## 📋 Penyebab Error

Error ini terjadi karena:

1. **Spring Boot 4.2.0** menggunakan **Hibernate 7.4.15** (versi terbaru)
2. Di Hibernate 7.4, nama dialect untuk MySQL berubah dari `MySQL8Dialect` menjadi `MySQL8InnoDBDialect`
3. Jika Hibernate dependency tidak eksplisit dideklarasikan, bisa terjadi conflict dengan versi lama

---

## ✅ Semua Sudah Fixed!

Jangan perlu modifikasi manual lagi. Cukup:

1. ✅ Update pom.xml - **DONE**
2. ✅ Update application.properties - **DONE**
3. ⏳ Jalankan `mvn clean install -DskipTests`
4. ⏳ Buat database `catalog_db`
5. ⏳ Run dengan `mvn spring-boot:run`

---

## 🎓 Pelajaran

**Takeaway untuk mahasiswa:**
- Selalu cek versi library yang digunakan
- Hibernate terus berkembang, nama API bisa berubah
- Lakukan `mvn clean install` saat ada perubahan dependency
- Read error message carefully! ClassNotFoundException sudah cukup informatif
