package org.com.testing.with.simpletest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class RVCustomAdapter(var source: List<Article>) :
    RecyclerView.Adapter<RVCustomAdapter.MyViewHolder>() {
    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val contentTextView: TextView = view.findViewById(R.id.mTextViewContent)
        val titleTextView: TextView = view.findViewById(R.id.mTextViewTitle)
        val imageView: ImageView = view.findViewById(R.id.mImageViewCardViewItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.card_view_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.contentTextView.text = source[position].content
        holder.titleTextView.text = source[position].title
        Picasso.get().load(source[position].imageURL).into(holder.imageView)
    }

    override fun getItemCount(): Int {
        return source.size
    }
}