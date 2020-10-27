package com.kotlinmessenger.views

import com.kotlinmessenger.R
import com.kotlinmessenger.models.User
import com.squareup.picasso.Picasso
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Item
import kotlinx.android.synthetic.main.chat_from_row.view.*
import kotlinx.android.synthetic.main.chat_to_row.view.*

class ChatFromItem(val message: String, val user: User): Item<GroupieViewHolder>() {
    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.itemView.textview_from_row.text = message

        val uri = user.profileImageUrl
        val imageTargetView = viewHolder.itemView.imageview_from_row
        Picasso.get().load(uri).into(imageTargetView)
    }

    override fun getLayout(): Int {
        return R.layout.chat_from_row
    }
}

class ChatToItem(val message: String, val user: User): Item<GroupieViewHolder>() {
    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.itemView.textview_to_row.text = message

        val uri = user.profileImageUrl
        val imageTargetView = viewHolder.itemView.imageview_to_row
        Picasso.get().load(uri).into(imageTargetView)
    }

    override fun getLayout(): Int {
        return R.layout.chat_to_row
    }
}