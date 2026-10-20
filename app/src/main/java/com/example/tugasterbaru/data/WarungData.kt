package com.example.tugasterbaru.data

data class Product(
    val id: Int,
    val name: String,
    val category: String,
    val price: Int,
    val unit: String,
    val rating: Double,
    val isBestSeller: Boolean = false,
    val stock: Int = 99
)

data class Order(
    val id: String,
    val date: String,
    val itemsSummary: String,
    val totalAmount: Int,
    val status: String, // "Diproses", "Dikirim", "Selesai"
    val paymentMethod: String // "Cash / COD", "QRIS", "Transfer"
)

object DummyWarungData {

    val categories = listOf(
        "Semua",
        "Sembako",
        "Minuman",
        "Mie & Instan",
        "Bensin Eceran",
        "Rokok & Korek",
        "Snack"
    )

    val sampleProducts = listOf(
        Product(1, "Beras Pandan Wangi 5 kg", "Sembako", 72000, "Karung", 4.9, isBestSeller = true),
        Product(2, "Minyak Goreng Bimoli 2 Liter", "Sembako", 36000, "Pouch", 4.8, isBestSeller = true),
        Product(3, "Bensin Pertalite Eceran 1L", "Bensin Eceran", 13000, "Botol", 5.0, isBestSeller = true),
        Product(4, "Indomie Goreng Spesial (Dus)", "Mie & Instan", 115000, "Dus", 4.9, isBestSeller = true),
        Product(5, "Indomie Goreng Spesial", "Mie & Instan", 31000, "10 Bungkus", 4.9),
        Product(6, "Telur Ayam Negeri 1 kg", "Sembako", 28000, "kg", 4.7),
        Product(7, "Teh Pucuk Harum 350ml", "Minuman", 3500, "Botol", 4.8),
        Product(8, "Le Minerale 600ml", "Minuman", 3000, "Botol", 4.9),
        Product(9, "Kopi Kapal Api Renceng", "Minuman", 15000, "Renceng (10)", 4.8),
        Product(10, "Sampoerna A Mild 16", "Rokok & Korek", 34000, "Bungkus", 4.8),
        Product(11, "Korek Api Gas Tokai", "Rokok & Korek", 3500, "Pcs", 4.9),
        Product(12, "Chitato Rasa Sapi Panggang", "Snack", 10500, "Bungkus", 4.7),
        Product(13, "Gula Pasir Gulaku 1 kg", "Sembako", 17500, "kg", 4.8)
    )

    val sampleOrders = listOf(
        Order(
            id = "WM-20250330-001",
            date = "Hari ini, 14:30",
            itemsSummary = "2x Bensin Pertalite 1L, 1x Indomie Goreng (10 Pcs)",
            totalAmount = 57000,
            status = "Dikirim",
            paymentMethod = "COD (Bayar di Tempat)"
        ),
        Order(
            id = "WM-20250329-042",
            date = "Kemarin, 21:15",
            itemsSummary = "1x Beras Pandan Wangi 5kg, 1x Minyak Bimoli 2L",
            totalAmount = 108000,
            status = "Selesai",
            paymentMethod = "QRIS"
        ),
        Order(
            id = "WM-20250328-019",
            date = "28 Mar 2025, 02:40",
            itemsSummary = "1x Sampoerna Mild, 2x Kopi Kapal Api, 1x Korek Tokai",
            totalAmount = 52500,
            status = "Selesai",
            paymentMethod = "Cash / Tunai"
        )
    )
}
