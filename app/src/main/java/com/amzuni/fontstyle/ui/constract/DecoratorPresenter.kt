package com.amzuni.fontstyle.ui.constract

import android.content.Context
import com.amzuni.fontstyle.R
import com.amzuni.fontstyle.model.Style

class DecoratorPresenter(context: Context) : DecoratorConstract.IPresenter {
    private lateinit var view : DecoratorConstract.IView
    private var context: Context
    private var styleList = mutableListOf<Style>()
    init {
        this.context = context
    }
    override fun setView(view: DecoratorConstract.IView) {
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

    override fun setTextDecorator(text: String) {
        createFancyStyleText(text)
        view.notifyDataChange()
    }
    fun createFancyStyleText(str: String) {
        styleList.get(0).value = "★·.·´¯`·.·★ " +    str + " ★·.·´¯`·.·★"
        styleList.get(1).value = "▁ ▂ ▄ ▅ ▆ ▇ █ " +    str + " █ ▇ ▆ ▅ ▄ ▂ ▁"
        styleList.get(2).value = "°°°·.°·..·°¯°·._.· " +   str + " ·._.·°¯°·.·° .·°°°"
        styleList.get(3).value = "¸,ø¤º°`°º¤ø,¸¸,ø¤º° " +  str + " °º¤ø,¸¸,ø¤º°`°º¤ø,¸"
        styleList.get(4).value = "ıllıllı " +  str + " ıllıllı"
        styleList.get(5).value = "•?((¯°·._.• " +  str + " •._.·°¯))؟•"
        styleList.get(6).value = "▌│█║▌║▌║ " + str + " ║▌║▌║█│▌"
        styleList.get(7).value = "×º°”˜`”°º× " +   str + " ×º°”˜`”°º×"
        styleList.get(8).value = "•]••´º´•» " +    str + " «•´º´••[•"
        styleList.get(9).value = "*•.¸♡ " +   str + " ♡¸.•*"
        styleList.get(10).value = "╰☆☆ " +   str + " ☆☆╮"
        styleList.get(11).value = ".•°¤*(¯`★´¯)*¤° " +    str + " °¤*(¯´★`¯)*¤°•."
        styleList.get(12).value = "(¯´•._.• " +    str + " •._.•´¯)"
        styleList.get(13).value = "¸„.-•~¹°”ˆ˜¨ " +    str + " ¨˜ˆ”°¹~•-.„¸"
        styleList.get(14).value = "░▒▓█ " +    str + " █▓▒░"
        styleList.get(15).value = "░▒▓█►─═ " + str + " ═─◄█▓▒░"
        styleList.get(16).value = "★彡 " +    str + " 彡★"
        styleList.get(17).value = "•´¯`•. " +  str + " .•´¯`•"
        styleList.get(18).value = "§.•´¨'°÷•..× " +    str + " ×,.•´¨'°÷•..§"
        styleList.get(19).value = "•°¯`•• " +  str + " ••´¯°•"
        styleList.get(20).value = "(¯`*•.¸,¤°´✿.｡.:* " +  str + " *.:｡.✿`°¤,¸.•*´¯)"
        styleList.get(21).value = "|!¤*'~``~'*¤!| " +  str + " |!¤*'~``~'*¤!|"
        styleList.get(22).value = "•._.••´¯``•.¸¸.•` " +   str + " `•.¸¸.•´´¯`••._.•"
        styleList.get(23).value = "¸„.-•~¹°”ˆ˜¨ " +    str + " ¨˜ˆ”°¹~•-.„¸"
        styleList.get(24).value = "(¯´•._.• " +    str + " •._.•´¯)"
        styleList.get(25).value = "••¤(`×[¤ " +    str + " ¤]×´)¤••"
        styleList.get(26).value = ",.-~*¨¯¨*·~-.¸-(_ " +   str + " _)-,.-~*¨¯¨*·~-.¸"
        styleList.get(27).value = "•´¯`•» " +  str + " «•´¯`•"
        styleList.get(28).value = ".o0×X×0o. " +   str + " .o0×X×0o."
        styleList.get(29).value = "¤¸¸.•´¯`•¸¸.•..>> " +   str + " <<..•.¸¸•´¯`•.¸¸¤"
        styleList.get(30).value = "—(••÷[ " +  str + " ]÷••)—"
        styleList.get(31).value = "¸,ø¤º°`°º¤ø,¸ " +   str + " ¸,ø¤º°`°º¤ø,¸"
        styleList.get(32).value = "`•.¸¸.•´´¯`••._.• " +   str + " •._.••`¯´´•.¸¸.•`"
        styleList.get(33).value = ",-*' ^ '~*-.,_,.-*~ " + str + " ~*-.,_,.-*~' ^ '*-,"
        styleList.get(34).value = "`•.,¸¸,.•´¯ " + str + " ¯`•.,¸¸,.•´"
        styleList.get(35).value = "↤↤↤↤↤ " +   str + " ↦↦↦↦↦"
        styleList.get(36).value = "➶➶➶➶➶ " +  str + " ➷➷➷➷➷"
        styleList.get(37).value = "↫↫↫↫↫ " +   str + " ↬↬↬↬↬"
        styleList.get(38).value = "·.¸¸.·♩♪♫ " +    str + " ♫♪♩·.¸¸.·"
        styleList.get(39).value = "【｡_｡】 " + str + " 【｡_｡】"
        styleList.get(40).value = "]|I{•------» " +    str + " «------•}I|["
        styleList.get(41).value = "▀▄▀▄▀▄ " +  str + " ▄▀▄▀▄▀"
        styleList.get(42).value = "(-_-) " +   str + " (-_-)"
        styleList.get(43).value = "•´¯`•. " +  str + " .•´¯`•"
        styleList.get(44).value = "-漫~*'¨¯¨'*·舞~ " + str + " ~舞*'¨¯¨'*·~漫-"
        styleList.get(45).value = "๑۞๑,¸¸,ø¤º°`°๑۩ " + str + " ๑۩ ,¸¸,ø¤º°`°๑۞๑"
        styleList.get(46).value = ".•°¤*(¯`★´¯)*¤° " +    str + " °¤*(¯´★`¯)*¤°•."
        styleList.get(47).value = "••.•´¯`•.•• " + str + " ••.•´¯`•.••"
        styleList.get(48).value = "¤¸¸.•´¯`•¸¸.•..>> " +   str + " <<..•.¸¸•´¯`•.¸¸¤"
        styleList.get(49).value = "◦•●◉✿ " +  str + " ✿◉●•◦"
        styleList.get(50).value = "╚»★«╝ " +  str + " ╚»★«╝"
        styleList.get(51).value = "-·=»‡«=·- " +   str + " -·=»‡«=·-"
        styleList.get(52).value = "∙∙·▫▫ᵒᴼᵒ▫ₒₒ▫ᵒᴼᵒ▫ₒₒ▫ᵒᴼᵒ " +  str + " ᵒᴼᵒ▫ₒₒ▫ᵒᴼᵒ▫ₒₒ▫ᵒᴼᵒ▫▫·∙∙"
        styleList.get(53).value = "¸¸♬·¯·♩¸¸♪·¯·♫¸¸ " +    str + " ¸¸♫·¯·♪¸¸♩·¯·♬¸¸"
        styleList.get(54).value = "ஜ۩۞۩ஜ " +   str + " ஜ۩۞۩ஜ"
        styleList.get(55).value = "¤ (¯´☆✭.¸_)¤ " +  str + " ¤(_¸.✭☆´¯) ¤"
        styleList.get(56).value = "(¯`·.¸¸.·´¯`·.¸¸.-> " + str + " <-.¸¸.·´¯`·.¸¸.·´¯)"
        styleList.get(57).value = "✿.｡.:* ☆:**:. " + str + " .:**:.☆*.:｡.✿"
        styleList.get(58).value = ".•♫•♬• " +    str + " •♬•♫•."
        styleList.get(59).value = "ღ(¯`◕‿◕´¯) ♫ ♪ ♫ " + str + " ♫ ♪ ♫ (¯`◕‿◕´¯)ღ"
        styleList.get(60).value = "«-(¯`v´¯)-« " + str + " »-(¯`v´¯)-»"
    }
}