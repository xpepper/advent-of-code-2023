package day03

private const val max_index = 139

fun main() {
    // a 140x140 matrix
    val input = listOf(
        ".........398.............551.....................452..................712.996.................646.40...1.....875..958.553...................",
        "..................................661..-844......*.../781...835..#163....*.......698.239.........*.....*.............*............*57.......",
        ".....................&...............*......+..139..................................*.........-.......282......................301..........",
        "........518..........918..-....472..172....776......207............38........................860..............274..945.....162..............",
        "........@..........#.....845..*........................*.............*....896...+.....153................@......*...*.......#.........441...",
        "..................740.21.....303...744.........190......173.395...729...-....&..925....@..5..............172...566..193...........#.........",
        "...598...967*.........*...........*.......164.=......91......*...........192................292...........................414=.215..........",
        ".............238.......661.....-.149.....&..........*........299...@644.................919*......*661..760....@.110*.......................",
        ".............................742.............$...125...+......................696..............523.......@..166......496..............#462..",
        ".588-.........#867.........................945.......457..505........%875......./.....+.........................965.........190.671.........",
        "........24.........278........934....*569................*..........................180............................=...........*............",
        "....988...*....151..@.........@............&...........242.................409................807..900#...417.886...........................",
        "...........330..#.......................729........&.........105......482..........679.........#...........*....$......752...749............",
        "...=............................../.............995...........*..689.....*.....-....#..............*604..696.......489..........+...193.&336",
        "..287.........17..737.......468....869.+.....................673...*......480...860........23...435............-..%.........................",
        "..............*............./..........552.............529.......271.+864..............848..#................771.......216........588...@...",
        "...........262.................185.........688....848.....*56...............%....$.......*...............362..............-..............250",
        "..507..............812.........*......................112.....556........754......841....959.........2..*...........248......232.527........",
        "....$....................478.627....175..........960.....+.....*......................#........790...=........503.....*.....$......*...%....",
        "..........................%........*........694.....*.......930...451+....248.......20..........*...........$...$..285..203......904..184...",
        "........531......30..969........435..772.........234..542.................*...............706....351.......571..........*...................",
        ".........#.......*...................*....&.8.........*.......313....+...807..398...........=.........540.........+....867............#.....",
        "............34...231.......934*....802..120........965........*.....424......*.........@.................@......974...........53......619...",
        ".....504....*........640.......127.............................671......316...538....151.......498........................914*..............",
        "......./.562........*...............504.....................................*.................+.....=..........835...................500....",
        "..787.........*122..149...$.................*....227.335....863*396......941.230.................847...215.......%..49..982..73.....*.......",
        "...-.......843..........240...932....@...352.830....*....*........................950........11...........*..........*........+.....819.....",
        "......354...........-...............66............&...501...................*.........39......*............513.651...482....................",
        ".....................160.........................437......&..797....551..337.383..735...*...546.............................................",
        ".......=........184......./.......67........476.........336....#......=...........*....426..........972..../960.....981......684*...........",
        "2...473....#....%......449........*......=.....%...........................877..890........+..../...................................834.....",
        "...........498..............926..887......147..................%.260...+..................965...939..../................894.....659*........",
        "....163...........*237................409......858...........184.*....33.......705...993*.............139..791....955.....@.639......668.455",
        ".......*.................128.....................-................677...........&........899...@....%......*.........*.........$.......*....",
        "613&.208..975......./837.-........772.554...........635#...927...........392....................761.300.....42.......68.................969.",
        "................389......................*.@...851.........*....344........*...90.....@231......................+...................182.....",
        "...-.286.296...&.......424...313......656..758....*.../..294...............722.#.......................689.......853.................%......",
        "546..+......*.................*...698...........664..190.....637.10...122........-758.........&753.827*.................#..@.....777....177.",
        "........490....$.............961.*....31..@................&..+..@.........781.........................................690.285.....*........",
        "...........*...421................720.*..133.=............298.......933.....&..=......805.461....531.......888.....................965......",
        ".....923*..310........219.302.................107.....457.....186#.*............691......*........*....89..*.....*..%695.946$...............",
        "........................#..........867.87...........................9......................623.432....*....678.819................+670......",
        "....673.......#809.68................*..$...127......422.......954........516*291.685..661..........163........................=............",
        ".....*....................648.....325........-......*....308..*....................-.....=.709&.366.........................219.............",
        "..132...439......$.......*.............134...........188.....134...257*38.300.77=...............................707.....................357.",
        "...........*..298........602..............%......940.......................*...........986@......438........710*...........594.....919......",
        ".....667..77................................305..*.......................941.....126...............*...............637......*..549*....116..",
        "......................876+..#516...........*....467.....981.....................*.......726.737.....434..149......%......776................",
        ".......@474..%..............................506........*........58............92.../37...*.....*633........+.........605.....239*72.........",
        "...148.......262......729....430.....................748...&...*...995...925........................*................*......................",
        "......=............................*....655..............254.566..*.....................*628.-356..769.............805......................",
        ".........229.................48@.251......*.......................733...521..........593..................148..............59%..632.........",
        "............*....69......................758........477........-......+......654.............................*173....................543....",
        "..........624.....#..480......@.................959....*......124..980...233*..........278........799/.260*........130......../741......*...",
        "............................373...=........265........436..%......................552.....*.........................*..423...............733",
        "316..93.............205............606....................994.316........824.#654...*..860.........947.956..470...550.+.............*682....",
        "......%....*487............185.........955..-...................$.364....-.........874......#865......*....../...................756........",
        "...........................*....512....*.....702.852....595.........*........942.......357........620....=......814..107....................",
        "....#275..650....204..840.......%......57.........*....#...........71.540/.........616....&.......*......899....=.....%....627.....435...849",
        ".....................*....../.....483.............363........................832..=............&..855.............-..........%.....@........",
        "..697..+..........661......36......-...*........%.........644...49......245..@...............434...............237...=................=.....",
        ".......398....773.............*131...248.300....627..............*.......=..........261....................422........621....780&..599......",
        "...............*......855@.517.....&......*..............592.721.714...........195.....%...........701.612..................................",
        "....855......943................182.......726..................*........274.6.....%.......799.........*........584..............972.........",
        ".....*............92.....637....................648............781.......*...-.............*............513...........542*.......@..........",
        "..249....834........+.........190....................216...........123...263.........................72.........413.......829...............",
        "............*...773.....*510....*.211=.................%...988......................488-.......214...#...........*....................315...",
        ".........+..508...&..144.....873........403....484../........@..606.533........918=...............*...........421.............230.528.......",
        "......650................34................-...%...74..........*......-..............*119.......25..749.....%............828.*....@....68...",
        "379.............&275..../.....768*805...................112.....237.......*855.....20........................773.....987.*....814.....*.....",
        ".........$.929.......&....................436..669.........@...........363...................278.....229.........402*................646....",
        "......897...*.......528............662@..........$.....#..........789.......&....436..282.............*.....................863.=...........",
        "..........311...........902..819....................118..679..710.......$...314...*......*181..345.530..$..388*......791....*...347.....#...",
        ".279................74*....$.................237...........#.*.........900......604............&.......455.....485.....*.548.........477....",
        "............928........734..............440.@.........................................989..........902...............431.................896",
        "........279........949.....659.....952....*....797.795...$...............4*..............*........*..........960*568........491.....236.....",
        "..........@.549.....*........$.670*.....254....*...*......184......&42.....129..........121.....486..................*.........&............",
        "...486......*.....846.......................757..................%.............................................699..829.....................",
        "....*..88..321...........4......535....594.......=...........=.511..167....-......*............853...............*.......87...........763...",
        ".303..$...................=.....*.........#..265..697.....462.......&...360....163.528.........*......774...127...770....@........891./.....",
        "........31......731..+278......667.....#........=...........................................328...591..*............................*...31..",
        "...................*.......927........420.650.......21.......918.......464.685.451..@................*..317....471*47.384...217..83.15..*...",
        "....234..219....303..700........#348........#.....%...@.......=...+..................403......419...82................&..........&.......798",
        "....*....*..........+..................738......857.....203*.....746...........................*..................*.........#...............",
        "...768.527.....77..................%........................623......393............643.......832........647+..773.421...402...29.370.......",
        ".................*175.......352.564.....237...*.+681.............=...*......&37...........832......../..........................*../..%.....",
        "......187..............218...................46......817.......893.139.............*..253*........436............../....619*.772.....532....",
        ".....*........165...+..................910......647.$..................@.511....143...................784..416...373........................",
        "..442...834...*....566....+876...34-..+........*...........507.......348.*............*..................*....%........590..................",
        ".........*..157.....................................344.......@..........988.......745.867............526..+...........*.....109.331.254-...",
        ".....456.............%..375*...........*.......199.+.........................846............=...............656.................*...........",
        "....*.......266...893.......441.....686.2...............455*748.............*..../980........726..................384................76.....",
        "....59......&..............................389..../.............427......645...............-......551..167..............130........*...*....",
        ".................=......10.....642........*.......536.29*........=...566........72*904..935...155*.......+...$360...703..*..252..870...739..",
        ".......252.......158......*......*.........695...........949............*............................................*.........*............",
        ".......*................830.......758...........................917...377......*519..622*439..../802..........665....481....231.............",
        ".......823..563.....................................167........*............334...................................................../.......",
        "..............*.................&.418/.&49......209*.......495..783..............185...%.............418/..........470.............289..831.",
        ".............60.559..........599............247......@.......$......170....884..*.......387..........................*......................",
        ".................*......*61.......................954...........216..*....*............................@.331....695.958.891*............351.",
        "......$...396........947.......234*....................994.981.......85....819.....435......./......594.....-...../.........592.............",
        "......605..*........................16....$.....907%....*..*...629.............958*....950.321...................................671........",
        "..........867.....821........987.....*...928.........275..687..*...904...300............*........864...................960.111.....*.148.19.",
        "..494.............*......410...#...517..........700...........714...*................988...........*.............445..*....*....473....-....",
        ".....*138............221*..............970......#....717...........26......$.....749..........253..330....214....*.........293..............",
        ".................%..........636..#........-.............*............./....180......&.532........*........*...403...........................",
        "............*..684......242...*...653..............374...822..........575...............*.....133...#...440...............322..780..........",
        ".........685..............*..658.......224...-.................%..........*118.........322........615.......981..........................806",
        ".337..............856..843............*....816....448..83=...824.839...568........989.........562......594.....*..........*21...833.........",
        ".....708...........*.......355.........437.......*..................*......*........-.944....../..185.....*...286..723..........+....552.652",
        "........-..73.......230....*......................927.%137.......754....490....782.......-...........*945.682......$...+............*.......",
        "............*.616=......*.595.......*...842..........................84.......*..................+....................80.........383..1.....",
        "..........357.........492...........771........68..........927*363..*.......262......69*224.......882.785..&313.............................",
        "...............................%391..............*....865............947.........583........*120........*..............449..../.../557......",
        ".........................634........8.....610..240.......*......508..............*.......875............297...717.941..*.......92...........",
        ".....874*180...&107.100......................*............453.......561....738.758..168.......................*....*....835........260..97..",
        ".650.....................230..................980.....................*....=...........*...605..396..........753..642..........537..........",
        "...*...........149.......&..........797.219............./743...................=.......333..*......*....882.................40*.............",
        "....103...348....%...............86..$.....*..99....................&...........25...........749..950..*.........................&..........",
        ".........@..............719.175.........652.....*............/......565.191.575.........................583........#./...........223........",
        "...........................*................295..358.806..520.............*..-...................%....+.....118..632.709...901...........790",
        "..562....221........735...........338..........*......+..........980....315............682....630.....762......*............................",
        "...............761....*......408.%.......971..246.................*................307......................949...............553...........",
        ".................*....194...*...............+...../.....$....$...301..............*.....857..........752#..........680.188..................",
        "..............551..........689.......*29...........345.75...898..................625....-......#732................&..../....876........576.",
        "..................................487......326*71......................143..................%........#.=.......................=............",
        "..42*....563......./..........976.......................496..233..224.....................270.....540..114....972.208....*...*.......950....",
        ".....667........915...283.....*........161*.......*764.........-....#.178...634+......569....................+........945...340.$.....*.....",
        ".........550............*.....973.694......209.228.....................*.................#..+..179@....832.......@..............67.448......",
        "............*...337..284..656......*..433............126.............860...857....*........411.........@.....=...977.....................726",
        "...815...896.....*.......*......993.....*.....309.....-..........735........./...985...*.....................797......842........$93........",
        ".....*.........424.......348........94...82.....*..........#25..*.....46*380...#......618.902.142.......972......$906...-....%96........482.",
        ".....12.............................../.......340...46.756.....327..=.........897...........@....*435...*..........................*546.....",
        ".................................185.....654........*.....*........772..+959............................581...13...918..388/....895.........",
        ".90............915.......758.664*........../.......885...564../160................830.869...........474.......*.......#.....................",
        "...*.....510....@........$..........$..............................813..795..........*....210........%......438..........786.......778.77...",
        "....984.....%...............+..712...83..*....130..................+....*...545.............*......+.............../.727./....826......*....",
        "................490......519../...........16....%...42.822..486......214..../...............985.480..............798....................249.",
        "........369*........317*.........632...#.............=...*.$........................-703.............+341............88.....*659...@........",
        "............595.........566.............847............456...................................182.........................791........533....."
    )
    val charArrays = input.map { it.toCharArray() }

    val numbers = mutableListOf<Int>()
    for (i in 0..max_index) {
        for (j in 0..max_index) {
            val e = charArrays[i][j]
            if (!e.isDigit() && e != '.') { // symbol found

                // adjacent in the previous row
                if (i > 0 && charArrays[i - 1][j].isDigit()) {
                    // up
                    detectNumberIn(charArrays[i - 1], j).let {
                        if (numbers.lastOrNull() != it) numbers.add(it)
                    }
                }
                if (i > 0 && j > 0 && charArrays[i - 1][j - 1].isDigit()) {
                    // up-left
                    detectNumberIn(charArrays[i - 1], j - 1).let {
                        if (numbers.lastOrNull() != it) numbers.add(it)
                    }
                }
                if (i > 0 && j < max_index && charArrays[i - 1][j + 1].isDigit()) {
                    // up-right
                    detectNumberIn(charArrays[i - 1], j + 1).let {
                        if (numbers.lastOrNull() != it) numbers.add(it)
                    }
                }

                // adjacent in the same row
                if (j > 0 && charArrays[i][j - 1].isDigit()) {
                    // previous
                    detectNumberIn(charArrays[i], j - 1).let {
                        if (numbers.lastOrNull() != it) numbers.add(it)
                    }
                }
                if (j < max_index && charArrays[i][j + 1].isDigit()) {
                    // following
                    detectNumberIn(charArrays[i], j + 1).let {
                        if (numbers.lastOrNull() != it) numbers.add(it)
                    }
                }

                // adjacent in the following row
                if (i < max_index && charArrays[i + 1][j].isDigit()) {
                    // down
                    detectNumberIn(charArrays[i + 1], j).let {
                        if (numbers.lastOrNull() != it) numbers.add(it)
                    }
                }
                if (i < max_index && j > 0 && charArrays[i + 1][j - 1].isDigit()) {
                    // down-left
                    detectNumberIn(charArrays[i + 1], j - 1).let {
                        if (numbers.lastOrNull() != it) numbers.add(it)
                    }
                }
                if (i < max_index && j < max_index && charArrays[i + 1][j + 1].isDigit()) {
                    // down-right
                    detectNumberIn(charArrays[i + 1], j + 1).let {
                        if (numbers.lastOrNull() != it) numbers.add(it)
                    }
                }
            }
        }
    }
    println(numbers.sum())
}

fun detectNumberIn(charArrays: CharArray, col: Int): Int {
    var i = col
    val stringBuilder = StringBuilder()

    while (charArrays[i].isDigit() && i > 0) {
        i--
    }
    if (i == 0) {
        if (!charArrays[i].isDigit()) i++
        while (charArrays[i].isDigit() && i < max_index) {
            stringBuilder.append(charArrays[i])
            i++
        }
    } else {
        while (i < max_index && charArrays[i + 1].isDigit()) {
            stringBuilder.append(charArrays[i + 1])
            i++
        }
    }
    val detectedNumber = stringBuilder.toString()
    return detectedNumber.toInt()
}

