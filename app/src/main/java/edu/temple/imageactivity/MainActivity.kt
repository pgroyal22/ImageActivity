package edu.temple.imageactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageObjects = arrayOf( ImageObject("Mount Rainier", R.drawable.rainier),
                                    ImageObject("Stony Man", R.drawable.stony_man),
                                    ImageObject("Grand Teton", R.drawable.grand_teton),
                                    ImageObject("Mount Haleakala", R.drawable.haleakala),
                                    ImageObject("Mount Massive", R.drawable.massive),
                                    ImageObject("Mount Denali (McKinley)", R.drawable.mckinley),
                                    ImageObject("Mount Washington", R.drawable.washington),
                                    ImageObject("Mount Whitney", R.drawable.whitney),
                                    ImageObject("Pikes Peak", R.drawable.pikes_peak),
                                    ImageObject("Half Dome", R.drawable.half_dome))

        val recycler = findViewById<RecyclerView>(R.id.recyclerView)
        recycler.layoutManager = GridLayoutManager(this, 2)

        val selectedDescriptorView = findViewById<TextView>(R.id.selectedImageDescriptionView)
        val selectedImageView = findViewById<ImageView>(R.id.selectedImageView)

        val itemSelectedListener =  object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, ID:  Long) {
                // finds whatever parent triggered the event
                val imageObject = parent?.getItemAtPosition(position) as ImageObject
                selectedImageView.setImageResource(imageObject.resourceID)
                selectedDescriptorView.text = imageObject.description
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
        recycler.adapter = ImageAdapter(this, imageObjects, itemSelectedListener)
    }
}