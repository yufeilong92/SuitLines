package cn.ruiye.suitlines

import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import tech.linjiang.suitlines.SuitLines
import tech.linjiang.suitlines.Units
import java.security.SecureRandom


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        suitlines.setHintColor(Color.TRANSPARENT)
        onBtnClick2(null);
        onBtnClick101(null);
        onBtnClick5(null)
        Handler().postDelayed({
            onBtnClick13(null)
            onBtnClick1(null)
        }, 200)
    }

    fun onBtnClick(view: View?) {
        suitlines.anim()
    }

    private var enable = false
    fun onBtnClick1(view: View?) {
        suitlines.setCoverLine(!enable.also { enable = it })
        suitlines.setCoverLine(1.0f)
    }

    fun onBtnClick13(view: View?) {
        val colors = IntArray(2)
//        colors[0] = color[SecureRandom().nextInt(8)]
        colors[0] = Color.WHITE
        colors[1] = Color.TRANSPARENT
        suitlines.setDefaultOneLineColor(colors)
    }

    private var curCount = 1

    fun onBtnClick2(view: View?) {
        suitlines.setXySize(8.0f.also { textSize = it.toFloat() })
        init(1.also { curCount = it })
    }

    fun onBtnClick3(view: View?) {
        init(++curCount)
    }

    fun onBtnClick4(view: View?) {
        if (curCount <= 1) {
            curCount = 1
        }
        init(--curCount)
    }

    fun onBtnClick5(view: View?) {
        suitlines.setLineForm(!suitlines.isLineFill())
    }


    fun onBtnClick6(view: View?) {
        suitlines.setLineStyle(if (suitlines.isLineDashed()) SuitLines.SOLID else SuitLines.DASHED)
    }

    fun onBtnClick7(view: View?) {
        suitlines.setLineType(if (suitlines.getLineType() === SuitLines.CURVE) SuitLines.SEGMENT else SuitLines.CURVE)
    }

    fun onBtnClick8(view: View?) {
        suitlines.disableEdgeEffect()
    }

    fun onBtnClick9(view: View?) {
        suitlines.setEdgeEffectColor(color[SecureRandom().nextInt(7)])
    }

    fun onBtnClick10(view: View?) {
        suitlines.setXyColor(color[SecureRandom().nextInt(7)])
    }

    private var textSize = 8f

    fun onBtnClick11(view: View?) {
        suitlines.setXySize(++textSize)
    }

    fun onBtnClick12(view: View?) {
        if (textSize < 6) {
            textSize = 6f
        }
        suitlines.setXySize(--textSize)
    }

    fun onBtnClick14(view: View?) {
        suitlines.disableClickHint()
    }

    fun onBtnClick15(view: View?) {

        suitlines.setHintColor(color[SecureRandom().nextInt(7)])
    }

    private val color =
        intArrayOf(
            Color.RED,
            Color.WHITE,
            Color.GRAY,
            Color.BLACK,
            Color.BLUE,
            -0x89fab,
            -0x64c9ab,
            -0x85fab
        )

    fun init(count: Int) {
        var count = count
        if (count <= 0) {
            count = 0
        }
        if (count == 1) {
            val lines: MutableList<Units> = ArrayList()
            //            for (int i = 0; i < 14; i++) {
//                lines.add(new Unit(new SecureRandom().nextInt(48), i + "d"));
//            }
            lines.add(Units(0.0f, "dd"))
            lines.add(Units(30.0f, "dd"))
            lines.add(Units(42.0f, "dd"))
            lines.add(Units(10.0f, "dd"))
            lines.add(Units(0.0f, "dd"))
            lines.add(Units(-10.0f, "dd"))
            lines.add(Units(35.0f, "dd"))
            lines.add(Units(15.0f, "dd"))
            lines.add(Units(0.0f, "dd"))
            lines.add(Units(-6.0f, "dd"))
            lines.add(Units(6.0f, "dd"))
            lines.add(Units(2.0f, "dd"))
            lines.add(Units(12.0f, "dd"))
            suitlines.feedWithAnim(lines)
            return
        }
        val builder = SuitLines.LineBuilder()
        for (j in 0 until count) {
            val lines: MutableList<Units> = ArrayList()
            for (i in 0..49) {
                lines.add(Units(SecureRandom().nextInt(128).toFloat(), "" + i))
            }
            builder.add(lines, *intArrayOf(color[SecureRandom().nextInt(7)], Color.WHITE))
        }
        builder.build(suitlines, true)
    }

    private var setShowYGrid = false
    fun onBtnClick101(view: View?) {
        suitlines.setShowYGrid(!setShowYGrid.also { setShowYGrid = it })
    }
}
