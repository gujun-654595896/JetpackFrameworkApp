package com.gujun.jetpack.ui.adapter

import androidx.recyclerview.widget.DiffUtil
import com.gujun.common.base.jetpack.ui.adapter.DataBindingPagingAdapter
import com.gujun.jetpack.BR
import com.gujun.jetpack.R
import com.gujun.jetpack.model.User

/**
 *    author : gujun
 *    date   : 2021/3/15 13:37
 *    desc   :
 */
class PagingListAdapter :
    DataBindingPagingAdapter<User>(diffCallback = diffCallback, itemBRId = BR.data) {

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

    override fun getLayoutId(): Int {
        return R.layout.app_item_binding
    }

}