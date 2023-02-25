import java.text.NumberFormat
import java.util.*

//global vaiable
    val scanner : Scanner = Scanner(System.`in`)
    val gol : Array<Int> = arrayOf(1,2,3)
    val gp : Array<Double> = arrayOf(2_500_000.00,4_500_000.00,6_500_000.00)
    val formatter : NumberFormat = NumberFormat.getInstance(Locale.US)

fun mainMenu(){
    println("|-------------------------------------------------|")
    println("|>> PROGRAM PERHITUNGAN GAJI KARYAWAN CV. LOGOS <<|")
    println("|-------------------------------------------------|")
}
fun showData(){
    for (i in gol.indices){
        val golongan = gol[i]
        val gajiPokok = gp[i]
        val gajiPokokCurrency = formatter.format(gajiPokok)
        println("| >> . Golongan [ $golongan ] Rp.$gajiPokokCurrency")
    }
}
fun iptNumber(message : String) : Int {
    println()
    println("|------------Form Input--------------|")
    print("| >> $message : ")
    return scanner.nextInt()
}
fun iptString(message : String) : String{
    println()
    println("|------------Form Input--------------|")
    print("| >> $message : ")
    return scanner.nextLine()
}

fun testMethod(){
    mainMenu()
    showData()
    val iptNama = iptString("Masukkan Nama").uppercase(Locale.getDefault())
    val iptJk = iptString("Masukkan Jenis Kelamin (l/p)")
    val iptKwin = iptString("Masukkan Kawin (y/t)")
    val iptGol = iptNumber(message = "Masukkan Golongan")
    var tjgnIstri = 0.0
    for (i in gol.indices){
        if (gol[i] == iptGol){
            val golongan = gol[i]
            val gajiPokok = gp[i]
            val gajiPokokFormatNumber = formatter.format(gajiPokok)
            println()
            println("| >> Data Pegawai : ")
            println("| >> Nama $iptNama")
            when (iptJk){
                "l" -> println("| >> Jenis Kelamin LAKI-LAKI")
                "P" -> println("| >> jenis kelamin PEREMPUAN")
                else -> println("Periksa Kembali Inputan Anda ")
            }
            when (iptKwin){
                "y" -> println("| >> Sudah Kawin")
                "t" -> println("| >> Belum Kawin")
                else -> println("Periksa Kembali Inputan Anda ")
            }
            println("| >> Golongan $golongan")
            println("| >> Gaji Pokok Rp.$gajiPokokFormatNumber")

            if (iptJk == "l" && iptKwin == "y"){
                when (golongan) {
                    1 -> {
                        tjgnIstri = gajiPokok * 0.01
                    }
                    2 -> {
                        tjgnIstri = gajiPokok * 0.03

                    }
                    3 -> {
                        tjgnIstri = gajiPokok * 0.05
                    }
                }
            }
            println()
            println("| >> TUNJANGAN : ")
            println("| >> Tunjangan Istri ${formatter.format(tjgnIstri)}")

        }
    }
}

fun main() {
    testMethod()
}