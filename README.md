# E-Commerce Backend Project

This is a **Spring Boot** backend project for an e-commerce platform. It provides basic CRUD operations for managing products and includes features like searching and image handling. The project is designed to be lightweight and easy to integrate with any frontend.

---

## 🛠 Features

- 🛍️ **Product Management**: Add, update, delete, and retrieve product details.
- 🔍 **Search Functionality**: Search for products based on name, description, brand, or category.
- 🖼️ **Image Handling**: Upload and retrieve images for products.
- ✅ **Basic Validation**: Ensures completeness of product data during creation and updates.

---

## 📂 Project Structure

### Key Files:
- 📄 **`ProductController.java`**: Handles HTTP requests and routes them to the service layer.  
- 📄 **`Product.java`**: Entity class for the `Product` model, defining attributes like `name`, `brand`, `price`, `category`, etc.  
- 📄 **`ProductsRepo.java`**: Repository interface for database operations, including custom queries for searching products.  

---

## 🚀 API Endpoints

### Base URL:
```
http://localhost:8080/api
```

### Endpoints:
| Method | Endpoint                | Description                             |
|--------|-------------------------|-----------------------------------------|
| 📥 GET    | `/products`             | Retrieve all products.                  |
| 📥 GET    | `/product/{id}`         | Retrieve a specific product by ID.      |
| ➕ POST   | `/product`              | Add a new product with an image.        |
| ✏️ PUT    | `/product/{id}`         | Update an existing product.             |
| ❌ DELETE | `/product/{id}`         | Delete a product by ID.                 |
| 🔍 GET    | `/products/search`      | Search products by a keyword.           |
| 🖼️ GET    | `/product/{id}/image`   | Retrieve the image of a product by ID.  |

---

## 🧪 Testing with Postman

1. **Import Endpoints**:
   - Use the base URL and endpoints to create requests in Postman.
   - Include headers like `Content-Type: multipart/form-data` for image uploads.

2. **Sample Requests**:
   - **Get All Products**:  
     `GET /products`
   - **Add a Product**:  
     Use the `POST /product` endpoint with the following body:
     - `product`: JSON object containing product details (name, price, etc.).
     - `imageFile`: Upload an image file for the product.
   - **Search Products**:  
     `GET /products/search?keyword=shoes`

3. **Authorization**:
   - No authentication is required for these endpoints.

---

## 🛠 Technologies Used

- ☕ **Spring Boot**: Backend framework.
- 🗃️ **JPA (Hibernate)**: Database interaction.
- 🐬 **MySQL**: Database storage.
- ✨ **Lombok**: For boilerplate code reduction.
- 🧪 **Postman**: For API testing.

---

## 📝 Notes

- Ensure that your database connection settings (e.g., username, password) are correctly configured in `application.properties`.
- You can easily integrate this backend with any frontend application (React, Angular, etc.).

---

Feel free to fork this repository and use it as a starting point for your projects. Contributions are welcome! 😊


