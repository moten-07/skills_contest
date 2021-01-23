package com.moten.DemoA

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_guide.*
import java.util.*

class GuideActivity : AppCompatActivity() {
    // 引导页主活动（kotlin版本）
    private val timer by lazy { Timer() }
    private var vpIndex: Int =0
    private val viewList: List<View> by lazy {
        listOf(
            LayoutInflater.from(this).inflate(R.layout.item_vp, null),
            LayoutInflater.from(this).inflate(R.layout.item_vp, null),
            LayoutInflater.from(this).inflate(R.layout.item_vp, null),
            LayoutInflater.from(this).inflate(R.layout.item_vp, null),
            LayoutInflater.from(this).inflate(R.layout.item_vp, null)
        )
        // 视图列表，lazy:延迟初始化————提高性能，使用时再初始化
    }
    private val pointarr by lazy {
        arrayOf(poin1,poin2,poin3,poin4,poin5)
    }
    private val sp by lazy { getSharedPreferences("config",Context.MODE_PRIVATE) }
    private val editor by lazy { sp.edit() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guide)

        if(sp.getBoolean("first_time",true)) // finish()
        btn_skip.setOnClickListener {
            editor.putBoolean("first_time",true)
            // finish()
        }

//        vp.offscreenPageLimit=1 // 设置预加载页面数量
        viewList[1].findViewById<ImageView>(R.id.imageView).setImageResource(R.drawable.ic_baseline_account_box_24)
        viewList[2].findViewById<ImageView>(R.id.imageView).setImageResource(R.drawable.ic_baseline_all_inclusive_24)
        viewList[3].findViewById<ImageView>(R.id.imageView).setImageResource(R.drawable.ic_baseline_accessibility_24)
        viewList[4].findViewById<ImageView>(R.id.imageView).setImageResource(R.drawable.ic_baseline_accessibility_24)
        vp.adapter=object : PagerAdapter(){         // vp插件，直接通过id访问本界面的控件,绑定适配器
        override fun isViewFromObject(view: View, `object`: Any): Boolean=(view == `object`)        // 省略下部代码
//            {TODO("Not yet implemented")
//                return view== `object`
//            } // 判断当前页面是否为绑定页面
            override fun getCount(): Int = viewList.size     // 返回可用的视图数量. 获取列表数量
            override fun instantiateItem(container: ViewGroup, position: Int): Any {
                val view =viewList[position]
                container.addView(view)
                return view
            }   // 返回单个view
                // 根据指定的位置创建一个page item
            override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
//                super.destroyItem(container, position, `object`)
                container.removeView(viewList[position])
            }
            // 移除给定位置的页面
            // 没有在缓存阶段时销毁，非必须
        }

        vp.addOnPageChangeListener( object :ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {}

            override fun onPageSelected(position: Int) {

                pointarr.forEachIndexed{index, _ ->
                    pointarr[index].setBackgroundResource(if (index == position) R.drawable.bg_point1 else R.drawable.bg_point2 )
                }   // 绑定单个图标
                btn_skip.visibility = if (position == 4) View.VISIBLE else View.GONE
                // 按钮显示
            }

        })
        timer.schedule(object : TimerTask() {
            override fun run() {
                runOnUiThread {
                    if (vpIndex == 4) {

                    } else{
                        vp.currentItem =vpIndex + 1
                        vpIndex++
                    }
                }
            }
        }, 2000, 3000)

    }
    override fun onDestroy() {
        super.onDestroy()
        timer.cancel()
    }
}