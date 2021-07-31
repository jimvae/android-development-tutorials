package net.simplifiedcoding.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recycler_view_author.view.*
import net.simplifiedcoding.R
import net.simplifiedcoding.data.Author

class AuthorsAdapter : RecyclerView.Adapter<AuthorsAdapter.AuthorViewModel>() {

    private var authors = mutableListOf<Author>()
    var listener: RecyclerViewClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = AuthorViewModel(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_view_author, parent, false)
    )

    override fun getItemCount() = authors.size

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: AuthorViewModel, position: Int) {
        holder.view.text_view_name.text = authors[position].name
//        holder.view.text_view_city_votes.text =
//            "${authors[position].city} | Votes : ${authors[position].votes}"
//        holder.view.button_edit.setOnClickListener {
//            listener?.onRecyclerViewItemClicked(it, authors[position])
//        }
//        holder.view.button_delete.setOnClickListener {
//            listener?.onRecyclerViewItemClicked(it, authors[position])
//        }
    }

    fun setAuthors(authors: List<Author>) {
        this.authors = authors as MutableList<Author>
        notifyDataSetChanged()
    }

    fun addAuthor(author: Author) {
        if (!authors.contains(author)) {
            authors.add(author)
        }
//        } else {
//            va l index = authors.indexOf(author)
//            if (author.isDeleted) {
//                authors.removeAt(index)
//            } else {
//                authors[index] = author
//            }
//        }
        notifyDataSetChanged()
    }

    class AuthorViewModel(val view: View) : RecyclerView.ViewHolder(view)
}