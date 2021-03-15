package com.gujun.jetpack.datasource

import androidx.paging.PagingSource
import com.gujun.jetpack.model.User

/**
 *    author : gujun
 *    date   : 2021/3/15 13:43
 *    desc   :
 */
class PagingListDataSource : PagingSource<Int, User>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, User> {
        val curKey = params.key ?: 0
        val userList = ArrayList<User>()
        for (i in 0..9) {
            val index = curKey * 10 + i
            userList.add(User("我是$index", index))
        }
        return LoadResult.Page<Int, User>(data = userList, prevKey = null, nextKey = curKey + 1)
    }

}