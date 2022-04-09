package id.sharekom.tugasgrid

import android.content.res.TypedArray
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.sharekom.tugasgrid.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = FoodListAdapter()
        val foodImages = resources.obtainTypedArray(R.array.food_images)
        val imageListDrawable = getImageListDrawable(foodImages)

        adapter.setData(imageListDrawable)
        binding.gridView.adapter = adapter

        foodImages.recycle()
    }

    private fun getImageListDrawable(foodImage: TypedArray): ArrayList<Int> {
        val imageList = ArrayList<Int>()
        for (i in 0 until foodImage.length()) {
            val image = foodImage.getResourceId(i, -1)
            imageList.add(image)
        }
        return imageList
    }
}