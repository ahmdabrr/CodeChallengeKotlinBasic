package MenuKasir

import CheckoutPelanggan.Member
import CheckoutPelanggan.NonMember

class Menu {
    fun menu() {
        do{
            print("""
                -----------------------------
                Selamat datang di SYNRGY MART
                -----------------------------
                1. Login
                0. Keluar
                
                Masukkan pilihanmu : 
            """.trimIndent())
            var inputMenu = readLine()

            when (inputMenu) {
                "1" -> Login().login()
                "0" -> print("Terimakasih telah berkunjung")

                else -> {
                    println("Inputan yang Anda masukkan tidak tersedia, silahkan coba kembali")
                    print("Masukkan pilihan menu (1/0) : ")
                    inputMenu = readLine()
                }
            }
        } while (inputMenu != "0" )
    }

    fun menuCheckout (username: String) {
        print("""
            -------------------------
            Selamat datang, $username
            -------------------------
            1. Checkout pelanggan
            0. Logout
            -------------------------
            Masukkan pilihanmu : 
        """.trimIndent())

        when (readLine()) {
            "1" -> {
                print("""
                    -------------------------
                    Checkout pelanggan member
                    -------------------------
                    Input nama member : 
                """.trimIndent())

                val namaMember = readLine().toString()
                Member(namaMember).inputPembelianBarang()
            }

            "2" -> NonMember().inputPembelianBarang()
        }
    }
}