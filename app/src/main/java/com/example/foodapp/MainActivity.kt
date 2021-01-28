
package com.example.foodapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.DocumentsContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter

private val View.textView: Unit
    get() {}
private val Any.setImageResource: Unit
    get() {}
private val View.imageView: Unit
    get() {}

class MainActivity : AppCompatActivity() {

    var adapter : FoodAdapter? = null
    var foodlist = ArrayList<Food>()




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        foodlist.add(Food(" Ice cream ","with chocolate"," 0"))
        foodlist.add(Food(" Honey ", " Honeycomb ",""))
        foodlist.add(Food(" KitKat" ," With white chocolate",""))
        foodlist.add(Food(" Jelly beans", " Effervescent",""))
        foodlist.add(Food(" Eclar"," With Effervescent",""))
        foodlist.add(Food(" Froyo"," With nuts",""))
        foodlist.add(Food(" Marshmallow", " with honey",""))
        foodlist.add(Food(" Ginger bread", " caramel",""))
        foodlist.add(Food(" Donats"," with caramel and fruit",""))
        foodlist.add(Food(" Lollipop","nuts", ""))

        adapter = FoodAdapter(this, foodlist)

    }

    class FoodAdapter : BaseAdapter{
        var foodlist = ArrayList<Food>()
        var context: Context? = null

        constructor(context: Context?, foodlist: ArrayList<Food>) : super() {
            this.foodlist = foodlist
            this.context = context
        }


        override fun getView(index: Int, p1: View?, p2: ViewGroup?): View {
            var food:Food= this.foodlist[index]
            var inflater :LayoutInflater = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var foodview :View  = inflater.inflate(R.layout.mylayout, null)
            foodview.imageView.setImageResource(food.image!!)
            foodview.textView.text = food.name!!
            return foodview
        }

        override fun getItem(p0: Int): Any {
            return p0
        }

        override fun getItemId(p0: Int): Long {

            return  p0.toLong()
        }

        override fun getCount(): Int {
            return foodlist.size
        }




    }
}

private operator fun Unit.invoke(image: Int) {

}
