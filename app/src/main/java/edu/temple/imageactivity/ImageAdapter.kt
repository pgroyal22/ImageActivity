package edu.temple.imageactivity

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ImageViewHolder(view: View) : RecyclerView.ViewHolder(view){
    val imageView : ImageView = view.findViewById(R.id.mountainImageView)
    lateinit var imageObject : ImageObject
}

class ImageAdapter (val _context : Context, _ImageObjects : Array<ImageObject>, _onClickListener: View.OnClickListener) : RecyclerView.Adapter<ImageViewHolder>() {
    private val ImageObjects : Array<ImageObject> = _ImageObjects
    val onClickListener = _onClickListener



    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ImageViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.recycler_element_layout, viewGroup, false)
        return ImageViewHolder(view)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val imageObject = this.ImageObjects[position]
        holder.imageView.setImageResource(imageObject.resourceID)
        holder.imageView.contentDescription = imageObject.description
        holder.imageView.setOnClickListener(onClickListener)


    }

    override fun getItemCount(): Int {
        return this.ImageObjects.size
    }
}