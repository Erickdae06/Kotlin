import java.text.NumberFormat
import java.util.*

//global variable
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
    return readln().toInt()

}
fun iptString(message : String) : String{
    println()
    println("|------------Form Input--------------|")
    print("| >> $message : ")
    return readln()
}

fun testMethod(){
    mainMenu()
    showData()
    val iptNama = iptString("Masukkan Nama").uppercase(Locale.getDefault())
    val iptJk = iptString("Masukkan Jenis Kelamin (l/p)").uppercase(Locale.getDefault())
    val iptKwin = iptString("Masukkan Kawin (y/t)").uppercase(Locale.getDefault())
    val iptGol = iptNumber(message = "Masukkan Golongan")
    var tjgnIstri = 0.0
    var tjgnAnak = 0.0
    var gajiBruto: Double
    var byJabatan: Double
    val iuranPensi = 15_000.00
    val iuranOrganisasi = 3_500.00
    var gajiNetto : Double
    for (i in gol.indices){
        if (gol[i] == iptGol){
            val golongan = gol[i]
            val gajiPokok = gp[i]
            val gajiPokokFormatNumber = formatter.format(gajiPokok)
            println()
            println("| >> Data Pegawai : ")
            println("| >> Nama $iptNama")
            when (iptJk){
                "L" -> println("| >> Jenis Kelamin LAKI-LAKI")
                "P" -> println("| >> jenis kelamin PEREMPUAN")
                else -> println(" | >> Periksa Kembali Inputan Anda ")
            }
            when (iptKwin){
                "Y" -> println("| >> Sudah Kawin")
                "T" -> println("| >> Belum Kawin")
                else -> println("Periksa Kembali Inputan Anda ")
            }

            println("| >> Golongan $golongan")
            println("| >> Gaji Pokok Rp.$gajiPokokFormatNumber")

//            hitung tunjangan istri
            if (iptJk == "L" && iptKwin == "Y"){
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

//            tunjangan anak
            if  (iptKwin == "Y") {
                val iptPnyaAnak = iptString(message = "Punya Anak? (y/t)").uppercase(Locale.getDefault())
                if (iptPnyaAnak == "Y"){
                    tjgnAnak = gajiPokok * 0.02
                }
            }


//            Gaji Bruto
            gajiBruto = gajiPokok + tjgnAnak + tjgnIstri
//          hitung biaya jabatan
            byJabatan = 0.005 * gajiBruto
            gajiNetto = gajiBruto - (byJabatan + iuranPensi + iuranOrganisasi)

            println("-------------------------------------------------------")
            println("| >> Tunjangan Istri ${formatter.format(tjgnIstri)}")
            println("| >> Tunjangan Anak ${formatter.format(tjgnAnak)}")
            println("| >> Gaji Bruto ${formatter.format(gajiBruto)}")
            println("-------------------------------------------------------")
            println("| >> Biaya Jabatan ${formatter.format(byJabatan)}")
            println("| >> Iuran Pensiun ${formatter.format(iuranPensi)}")
            println("| >> Iuran Organisasi ${formatter.format(iuranOrganisasi)}")
            println("| >> Gaji Netto ${formatter.format(gajiNetto)}")



        }
    }
}

fun main() {
    do {
        testMethod()
        val iptUlang = iptString("Ulangi program?").uppercase(Locale.getDefault())
    }while (iptUlang == "Y")
}