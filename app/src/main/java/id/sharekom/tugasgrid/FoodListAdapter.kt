package id.sharekom.tugasgrid

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.core.content.res.ResourcesCompat
import id.sharekom.tugasgrid.databinding.ItemFoodBinding

class FoodListAdapter: BaseAdapter() {
    private var listData = ArrayList<Int>()

    fun setData(listData : ArrayList<Int>) {
        this.listData = listData
    }

    override fun getCount(): Int = listData.size

    override fun getItem(p0: Int): Int = listData[p0]

    override fun getItemId(p0: Int): Long = p0.toLong()

    override fun getView(position: Int, view: View?, parent: ViewGroup?): View {
        val binding = ItemFoodBinding.inflate(LayoutInflater.from(parent?.context), parent, false)

        binding.ivFood.setImageDrawable(
            ResourcesCompat.getDrawable(parent?.context?.resources!!, listData[position], null)
        )

        return binding.root
    }
}