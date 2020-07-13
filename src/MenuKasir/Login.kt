package MenuKasir

class Login {
    private val username : String = "MasAgus"
    private val password : String = "apaajaboleh"

    fun login() {
        print("""
            ------------------------------
            Selamat datang di SYNRGY MART
            ------------------------------
            + Login kasir +
            Username : 
        """.trimIndent())
        val inputUsername = readLine()
        print("Password : ")

        val inputPassword = readLine()
        print("---------------------------")

        if (inputUsername == username && inputPassword == password) {
            Menu().menuCheckout(username)
        } else {
            print("Username atau password salah")
            Menu().menu()
        }
    }
}