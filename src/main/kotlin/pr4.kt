//Проверка правильности оператора for, у которого начальным и ко-
//нечным значениями могут быть как целые числа, так и символы, а
//
//тело цикла – оператор write(ln), у которого аргументы – целые и ве-
//щественные числа и переменные.
//\2
fun main() {
    val reg = Regex("""^\s*for\s*([A-Za-z_][A-Za-z_0-9]*)\s*:=\s*(\'[^']\'|''''|#\d+|(|\+|\-)\d+|(|\+|\-)\d+(E|e)\d+)\s*(|down)to\s*(\'[^']\'|''''|#\d+|(|\+|\-)\d+|(|\+|\-)\d+(E|e)\d+)\s*write(|ln)\(((|\+|\-)\d+|\2|(|\+|\-)\d+\.\d+|(|\+|\-)\d*(E|e)\d+|(|\+|\-)\d+\.\d+(E|e)\d+)\)\s*;""", RegexOption.IGNORE_CASE)
    println(reg.matchEntire("    for dv := #2 to '''' writeln(x,y,z);")?.groupValues)
}
