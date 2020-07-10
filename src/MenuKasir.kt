import javax.swing.MenuElement

class MenuKasir {
    val databaseUsers = mapOf("Abrar" to "123456", "Johan" to "123456", "Alfi" to "123456")

    fun menuUtama(){
        println("""
            1. Checkout Pelanggan 
            0. Logout   
        """.trimIndent())

    }

   fun login () {
   println("""
       -----------------------------
       Selamat datang di Synrgy Mart
       -----------------------------
       + Login Kasir +
       """.trimIndent())
        print("Username : ")
        val usernameInput = readLine()
        print("Password : ")
        val passworInput = readLine()

       if (!databaseUsers.containsKey(usernameInput) || passworInput != databaseUsers.get(usernameInput)){
           println("username atau password salah")
           login()
       } else {
           keCheckOut()

        }
        }
        fun keCheckOut () {
            println("""
               -----------------------------------
               Selamat datang, 
               -----------------------------------
               1. Checkout Pelanggan
               0. Logout
           """.trimIndent())
            print("Pilih Menu : ")
            var inputPelanggan = readLine()!!

            if (inputPelanggan == "1") {
                MenuCheckout().checkoutPelanggan()
        }
    }
}

