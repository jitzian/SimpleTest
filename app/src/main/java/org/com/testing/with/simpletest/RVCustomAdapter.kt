package org.com.testing.with.simpletest

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import org.com.testing.with.simpletest.databinding.CardViewItemBinding

/**
 * TODO: Implement the Adapter that will populate a RecyclerView using the information generated in ViewModel
 * */

class RVCustomAdapter(private val dataset: List<Article>): RecyclerView.Adapter<RVCustomAdapter.ArticleViewHolder>() {

    class ArticleViewHolder(private val binding: CardViewItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bindData(itemViewType: Article) {
            binding.apply {
                mTextViewTitle.text = itemViewType.title
                mTextViewContent.text = itemViewType.content
                Picasso.Builder(mImageViewCardViewItem.context).build().load(itemViewType.imageURL).into(mImageViewCardViewItem)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        return ArticleViewHolder(CardViewItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount() = dataset.size

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        holder.bindData(dataset[position])
    }


}