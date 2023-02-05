package kr.or.mrhi.cinemastorage.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import kr.or.mrhi.cinemastorage.R

class IntroAdapter(private val context: Context) : PagerAdapter() {

    private var layoutInflater: LayoutInflater? = null

    private val banners = arrayOf(
        R.drawable.banner_first,
        R.drawable.banner_second,
        R.drawable.banner_third,
    )

    override fun getCount(): Int {
        return banners.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object` as View
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        val view = layoutInflater?.inflate(R.layout.adapter_intro, container, false)
        val image = view?.findViewById<View>(R.id.iv_banner) as ImageView
        val viewPager = container as ViewPager

        image.setImageResource(banners[position])
        viewPager.addView(view, 0)

        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        val viewPager = container as ViewPager
        val view = `object` as View
        viewPager.removeView(view)
    }

}