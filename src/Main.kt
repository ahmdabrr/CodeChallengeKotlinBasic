fun main(){
      println("""
            -----------------------------
            Selamat Datang di Synrgy Mart
            -----------------------------
            1. Login 
            0. Keluar
        """.trimIndent())
        print("Pilih Menu : ")
        var inputUser = readLine()!!

        if (inputUser == "1") {
            MenuKasir().login()
    }

}