package com.gujun.jetpack.ui.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import com.gujun.common.base.ui.adapter.BaseRecyclerAdapter
import com.gujun.jetpack.R
import com.gujun.jetpack.model.User

/**
 *    author : gujun
 *    date   : 2021/3/15 10:40
 *    desc   :
 */
class RecyclerListAdapter : BaseRecyclerAdapter<User>(diffCallback = diffCallback) {

    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<User>() {
            override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onUpdateItemData(itemView: View, item: User, position: Int) {
        itemView.findViewById<TextView>(R.id.content).text = item.name
    }

    override fun getLayoutId(): Int {
        return R.layout.app_item_recycler
    }

}