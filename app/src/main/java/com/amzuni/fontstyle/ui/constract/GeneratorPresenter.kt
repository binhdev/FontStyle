package com.amzuni.fontstyle.ui.constract

import android.content.Context
import com.amzuni.fontstyle.R
import com.amzuni.fontstyle.model.Style
import java.util.Locale

class GeneratorPresenter(context: Context) : GeneratorConstract.IPresenter {
    private lateinit var view : GeneratorConstract.IView
    private var context: Context
    private var styleList = mutableListOf<Style>()
    init {
        this.context = context
    }
    override fun setView(view: GeneratorConstract.IView) {
        this.view = view
    }

    override fun getStyleList() {
        val fontGenerator: Array<String> = context.resources.getStringArray(R.array.font_generator)
        fontGenerator.forEach {
            val item = it.split("|")
            val style = Style(item[0], item[1])
            styleList.add(style)
        }

        view.updateStyleListUI(styleList)
    }

    override fun setTextGenerator(text: String) {
        createFancyStyleText(text)
        view.notifyDataChange()
    }
    fun createFancyStyleText(str: String) {
        var str2: String
        var i = 13
        val strArr = arrayOf(
            "ⓐⓑⓒⓓⓔⓕⓖⓗⓘⓙⓚⓛⓜⓝⓞⓟⓠⓡⓢⓣⓤⓥⓦⓧⓨⓩⒶⒷⒸⒹⒺⒻⒼⒽⒾⒿⓀⓁⓂⓃⓄⓅⓆⓇⓈⓉⓊⓋⓌⓍⓎⓏ⓪①②③④⑤⑥⑦⑧⑨",
            "ᴀʙᴄᴅᴇғɢʜɪᴊᴋʟᴍɴᴏᴘǫʀsᴛᴜᴠᴡxʏᴢᴀʙᴄᴅᴇғɢʜɪᴊᴋʟᴍɴᴏᴘǫʀsᴛᴜᴠᴡxʏᴢ0123456789",
            "αв¢∂єfgнιנкℓмиσρqяѕтυνωχуzαв¢∂єfgнιנкℓмиσρqяѕтυνωχуz0123456789",
            "₳฿₵ĐɆ₣₲ⱧłJ₭Ⱡ₥₦Ø₱QⱤ₴₮ɄV₩ӾɎⱫ₳฿₵ĐɆ₣₲ⱧłJ₭Ⱡ₥₦Ø₱QⱤ₴₮ɄV₩ӾɎⱫ0123456789",
            "αвcdєfghíjklmnσpqrstuvwхчzαвcdєfghíjklmnσpqrstuvwхчz0123456789",
            "ᎪbᏟᎠᎬfᎶhᎥjᏦᏞmᏁᎾᏢqᏒsᏆuᏉᎳxᎽᏃᎪbᏟᎠᎬfᎶhᎥjᏦᏞmᏁᎾᏢqᏒsᏆuᏉᎳxᎽᏃ0123456789",
            "ᗩᗷᑕᗪEᖴGᕼIᒍKᒪᗰᑎOᑭᑫᖇᔕTᑌᐯᗯ᙭YᘔᗩᗷᑕᗪEᖴGᕼIᒍKᒪᗰᑎOᑭᑫᖇᔕTᑌᐯᗯ᙭Yᘔ0123456789",
            "ǟɮƈɖɛʄɢɦɨʝӄʟʍռօքզʀֆȶʊʋաӼʏʐǟɮƈɖɛʄɢɦɨʝӄʟʍռօքզʀֆȶʊʋաӼʏʐ0123456789",
            "ḀḃḉḊḕḟḠḧḭjḲḶṁṆṏṖqṙṠṮṳṼẇẌẏẒḀḂḈḊḔḞḠḦḬJḲḶṀṆṎṖQṘṠṮṲṼẆẌẎẒ0123456789",
            "ａｂｃｄｅｆｇｈｉｊｋｌｍｎｏｐｑｒｓｔｕｖｗｘｙｚＡＢＣＤＥＦＧＨＩＪＫＬＭＮＯＰＱＲＳＴＵＶＷＸＹＺ０１２３４５６７８９",
            "ᴀʙᴄᴅᴇғɢʜɪᴊᴋʟᴍɴᴏᴘϙʀꜱᴛᴜᴠᴡxʏᴢABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789",
            "ɐqɔpǝɟƃɥıɾʞlɯuodbɹsʇnʌʍxʎzɐqɔpǝɟƃɥıɾʞlɯuodbɹsʇnʌʍxʎz0123456789",
            "äḅċďệḟġḧïjḳŀṃńöṗqŕṩẗüṿẅẍÿẓÄḄĊĎỆḞĠḦÏJḲĿṂŃÖṖQŔṨṮÜṾẄẌŸẒ0123456789"
        )
        for (i2 in 0..12) {
            var str3 = str
            for (i3 in 0..61) {
                str3 = str3.replace(
                    "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"[i3].toString()
                        .toRegex(), strArr[i2][i3].toString()
                )
            }
            styleList.get(i2).value = str3
        }
        for (i4 in 13..28) {
            styleList.get(i4).value = str
        }
        val str4 = str
        var i5 = 0
        while (i5 < 62) {
            styleList.get(i).value =
                styleList.get(i).value?.replace(
                "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"[i5].toString(),
                "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"[i5].toString() + "̶"
            )

            styleList.get(14).value =
                styleList.get(14).value?.replace(
                "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"[i5].toString(),
                "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"[i5].toString() + "̴"
            )
            styleList.get(15).value =
                styleList.get(15).value?.replace(
                "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"[i5].toString(),
                "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"[i5].toString() + "̷"
            )
            styleList.get(16).value =
                styleList.get(16).value?.replace(
                "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"[i5].toString(),
                "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"[i5].toString() + "̲"
            )
            styleList.get(17).value =
                styleList.get(17).value?.replace(
                "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"[i5].toString(),
                "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"[i5].toString() + "̳"
            )
            styleList.get(18).value =
                styleList.get(18).value?.replace(
                "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"[i5].toString(),
                "[̲̅" + "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"[i5] + "̲̅]"
            )
            styleList.get(19).value =
                styleList.get(19).value?.replace(
                "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"[i5].toString(),
                "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"[i5].toString() + "̾"
            )
            styleList.get(20).value =
                styleList.get(20).value?.replace(
                "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"[i5].toString(),
                "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"[i5].toString() + "͆"
            )
            styleList.get(21).value =
                styleList.get(21).value?.replace(
                "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"[i5].toString(),
                "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"[i5].toString() + "̺"
            )
            styleList.get(22).value =
                styleList.get(22).value?.replace(
                "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"[i5].toString(),
                "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"[i5].toString() + "͙"
            )
            styleList.get(23).value =
                styleList.get(23).value?.replace(
                    "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"[i5].toString(),
                    "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"[i5].toString() + "̟"
                )
            styleList.get(24).value =
                styleList.get(24).value?.replace(
                    "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"[i5].toString(),
                    "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"[i5].toString() + "͓̽"
                )
            styleList.get(25).value =
                styleList.get(25).value?.replace(
                    "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"[i5].toString(),
                    "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"[i5].toString() + "͎"
                )
            styleList.get(26).value =
                styleList.get(26).value?.replace(
                    "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"[i5].toString(),
                    "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"[i5].toString() + "♥"
                )
            styleList.get(27).value =
                styleList.get(27).value?.replace(
                    "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"[i5].toString(),
                    "【" + "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"[i5] + "】"
                )
            styleList.get(28).value =
                styleList.get(28).value?.replace(
                    "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"[i5].toString(),
                    "『" + "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"[i5] + "』"
                )
            i5++
            i = 13
        }
        val strArr2 = arrayOf(
            "αвc∂εғgнιנкℓмησρqяsтυvωxүz",
            "卂乃匚ᗪ乇千Ꮆ卄丨ﾌҜㄥ爪几ㄖ卩Ɋ尺丂ㄒㄩᐯ山乂ㄚ乙",
            "ĂβČĎĔŦĞĤĨĴĶĹМŃŐРQŔŚŤÚVŴЖŶŹ",
            "ɐqɔpǝɟƃɥ!ɾʞןɯuodbɹsʇnʌʍxʎz",
            "ΔβĆĐ€₣ǤĦƗĴҜŁΜŇØƤΩŘŞŦỮVŴЖ¥Ž",
            "αɓ૮∂εƒɠɦเʝҡℓɱɳσρφ૨รƭµѵωאყƶ",
            "aвcdeғgнιjĸlмnopqrѕтυvwхyz",
            "ⒶⒷⒸⒹⒺⒻⒼⒽⒾⒿⓀⓁⓂⓃⓄⓅⓆⓇⓈⓉⓊⓋⓌⓍⓎⓏ",
            "ąცƈɖɛʄɠɧıʝƙƖɱŋơ℘զཞʂɬų۷ῳҳყʑ",
            "ꍏꌃꉓꀸꍟꎇꁅꃅꀤꀭꀘ꒒ꎭꈤꂦᖘꆰꋪꌗ꓄ꀎᐯꅏꊼꌩꁴ",
            "αвcdєfghíjklmnσpqrѕtuvwхчz",
            "ДᏰℂ∂ƎƒᎶℍîʝƘℓℳИøρǪЯƧ✞υϑᏔ✘УՀ",
            "ДБCDΞFGHIJҜLMИФPǪЯSΓЦVЩЖУZ",
            "ǟɮƈɖɛʄɢɦɨʝᏦʟʍռօքզʀֆᏆʊʋաxʏʐ",
            "ɑҍϲժҽƒցհíյƘӀʍղօԹզɾՏԵմѵա×վՀ",
            "ᴬᴮᶜᴰᴱᶠᴳᴴᴵᴶᴷᴸᴹᴺᴼᴾᵟᴿˢᵀᵁᵛᵂˣᵞᶻ",
            "ᕱც꒝Ꭰꂅꊰg♅ᎥϳКլოภԾᎵգᏒᏕϮuᏉᎳꊼᎩᏃ",
            "ᗅᙘᑤᗫᙍᖴᘜᕼᓿᒙᖽᐸᒪᙢᘉᓎᕿᕴᖇSᖶᑗᐻᙎ᙭ᖻᙣ",
            "ΛϦㄈÐƐFƓнɪﾌҚŁ௱ЛØþҨ尺らŤЦƔƜχϤẔ",
            "ƛƁƇƊЄƑƓӇƖʆƘԼMƝƠƤƢƦƧƬƲƔƜҲƳȤ",
            "คც८ძ૯Բ૭ҺɿʆқՆɱՈ૦ƿҩՐς੮υ౮ω૪עઽ",
            "ԹՅՇԺȝԲԳɧɿʝƙʅʍՌԾρφՐՏԵՄעաՃՎՀ",
            "ﾑ乃ᄃり乇ｷムんﾉﾌズﾚﾶ刀のｱゐ尺丂ｲひ√Wﾒﾘ乙",
            "αßςdεƒghïյκﾚmη⊕pΩrš†u∀ωxψz",
            "ᏗᏰፈᎴᏋᎦᎶᏂᎥᏠᏦᏝᎷᏁᎧᎮᎤᏒᏕᏖᏬᏉᏇጀᎩፚ",
            "ꍏꌃꉓꀸꍟꎇꁅꃅꀤꀭꀘ꒒ꂵꈤꂦꉣꆰꋪꌗ꓄ꀎꃴꅏꊼꌩꁴ",
            "ꁲꃃꇃꂡꏹꄙꁍꀍꀤꀭꈵ꒒ꂵꋊꁏꉣꆰꋪꌚꋖꌈꃴꅐꋚꂖꁴ",
            "ꋫꃲꉓꃸꑾꄘꁅꃄ꒐꒑ꀗ꒒ꂵꁹꄱꉣꋟꋪꇘ꓅ꌇ꒦ꅏꋋꌥ꒗",
            "ꋬꍗꏳꂟꏂꄟꍌꃬ꒐꒻ꀘ꒒ꂵꂚꉻꉣꋠꋪꑄ꓄ꀎ꒦ꅐꉼꐞꑓ",
            "ค๖¢໓ēfງhiวkl๓ຖ໐p๑rŞtนงຟxฯຊ",
            "ᗩᗷᑕᗪᗴᖴǤᕼᎥᒎᛕᒪᗰᑎᗝᑭɊᖇᔕ丅ᑌᐯᗯ᙭Ƴ乙",
            "ᗩᗷᑢᕲᘿᖴᘜᕼᓰᒚᖽᐸᒪᘻᘉᓍᕵᕴᖇSᖶᑘᐺᘺ᙭ᖻᗱ",
            "åβçď£ƒğȟȋjķȽɱñ¤קǭȑ§țɥ√Ψ×ÿž",
            "ąβȼď€ƒǥhɨjЌℓʍɲ๏ρǭя§ţµ˅ώж¥ƶ",
            "მჩეძპfცhἶქκlოῆõρგΓჰནυὗwჯყɀ",
            "ÃβČĎẸƑĞĤĮĴЌĹϻŇỖƤǪŘŜŤǗϋŴЖЎŻ",
            "ልጌርዕቿቻኗዘጎጋጕረጠክዐየዒዪነፕሁሀሠሸሃጊ",
            "ꋫꃃꏸꁕꍟꄘꁍꑛꂑꀭꀗ꒒ꁒꁹꆂꉣꁸ꒓ꌚ꓅ꐇꏝꅐꇓꐟꁴ",
            "ꋬꃳꉔ꒯ꏂꊰꍌꁝ꒐꒻ꀘ꒒ꂵꋊꄲꉣꆰꋪꇙ꓄꒤꒦ꅐꉧꌦꁴ",
            "ꁲꃳꏳꀷꑀꊯꁅꁝ꒐꒑ꈵ꒒ꂵꃔꊿꉣꋠꌅꈜꋖꌈ꒦ꅐꉤꐔꑒ",
            "ꁲꋰꀯꂠꈼꄞꁅꍩꂑ꒻ꀗ꒒ꂵꋊꂦꉣꁷꌅꌚꋖꐇꀰꅏꇒꐞꁴ"
        )
        for (i6 in 0..40) {
            var lowerCase = str.lowercase(Locale.getDefault())
            for (i7 in 0..25) {
                str2 = if (i6 != 17 && i6 != 31) {
                    strArr2[i6][i7].toString()
                } else if (i7 < 10) {
                    strArr2[i6][i7].toString()
                } else if (i7 > 10) {
                    strArr2[i6][i7 + 1].toString()
                } else {
                    strArr2[i6][i7].toString() + strArr2[i6][i7 + 1].toString()
                }
                lowerCase =
                    lowerCase.replace("abcdefghijklmnopqrstuvwxyz"[i7].toString().toRegex(), str2)
            }
            styleList.get(29 + i6).value =
                lowerCase
        }
    }
}