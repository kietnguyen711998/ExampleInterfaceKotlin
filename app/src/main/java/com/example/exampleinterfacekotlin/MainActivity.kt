package com.example.exampleinterfacekotlin

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.exampleinterfacekotlin.`interface`.OnItemClick
import com.example.exampleinterfacekotlin.adapter.GroupAdapter
import com.example.exampleinterfacekotlin.adapter.UserAdapter
import com.example.exampleinterfacekotlin.model.Group
import com.example.exampleinterfacekotlin.model.User
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var mListUser: MutableList<User> = mutableListOf<User>()
    private var mListGroup: MutableList<Group> = mutableListOf<Group>()
    private lateinit var mAdapterGroup: GroupAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mListUser.add(User("Mark Zuckerberg", "New  York", "0745xxx"))
        mListUser.add(User("Elon Musk", "California", "0777xxx"))
        mListUser.add(User("Jeff Bezos", "New  Mexico", "0795xxx"))
        mListUser.add(User("Steve Jobs", "Palo Alto, California", "0706xxx"))
        mListUser.add(User("Donald Trump", "New  York City", "0735xxx"))

        var mAdapterUser = UserAdapter(mListUser, object : OnItemClick {
            override fun onView(position: Int) {
                Toast.makeText(
                    this@MainActivity,
                    mListUser[position].mName + " - " + mListUser[position].mAddress,
                    Toast.LENGTH_LONG
                ).show()
            }

            override fun onCheck(position: Int, isCheck: Boolean) {
                if (isCheck) {
                    mListGroup.add(Group(position, mListUser[position].mName))
                } else {
                    val iterator = mListGroup.iterator()
                    while (iterator.hasNext()) {
                        if (iterator.next().mIdGroup == position) {
                            iterator.remove()
                        }
                    }
                }
                mAdapterGroup!!.notifyDataSetChanged()
            }
        })
        //RecyclerView User
        val linearLayoutUser = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        mRecyclerViewUser.layoutManager = linearLayoutUser
        mRecyclerViewUser.adapter = mAdapterUser

        //RecyclerView Group
        mAdapterGroup = GroupAdapter(mListGroup)
        val linearLayoutGroup = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        mRecyclerViewGroup.layoutManager = linearLayoutGroup
        mRecyclerViewGroup.adapter = mAdapterGroup
    }
}