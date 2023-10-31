package com.amzuni.fontstyle.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.amzuni.fontstyle.R
import com.amzuni.fontstyle.adapter.SpacesItemDecoration
import com.amzuni.fontstyle.adapter.StyleAdapter
import com.amzuni.fontstyle.base.BaseFragment
import com.amzuni.fontstyle.model.Style
import com.amzuni.fontstyle.ui.constract.DecoratorConstract
import com.amzuni.fontstyle.ui.constract.DecoratorPresenter
import com.amzuni.fontstyle.ui.constract.GeneratorConstract
import com.amzuni.fontstyle.ui.constract.GeneratorPresenter


class DecoratorFragment : BaseFragment(), DecoratorConstract.IView {
    private lateinit var mPresenter : DecoratorConstract.IPresenter
    private lateinit var mRvStyle : RecyclerView
    private lateinit var svStyle: SearchView
    private lateinit var mAdapter: StyleAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewRoot = inflater.inflate(R.layout.fragment_decorator, container, false)
        loadAdsBanner(viewRoot)

        val itemDecoration = SpacesItemDecoration(resources.getDimensionPixelOffset(R.dimen.m2))

        mRvStyle = viewRoot.findViewById(R.id.rv_style)
        mRvStyle.layoutManager = LinearLayoutManager(requireContext())
        mRvStyle.addItemDecoration(itemDecoration)

        svStyle = viewRoot.findViewById(R.id.sv_style)
        svStyle.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                return false
            }
            override fun onQueryTextChange(newText: String): Boolean {
                if(newText.trim().isEmpty()) mPresenter.setTextDecorator("CoolStyles.org")
                else mPresenter.setTextDecorator(newText)
                return false
            }
        })
        return viewRoot
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        loadAdsBanner()
        mPresenter = DecoratorPresenter(requireContext())
        mPresenter.setView(this)
        mPresenter.getStyleList()
    }

    override fun updateStyleListUI(styleList: MutableList<Style>) {
        mAdapter = StyleAdapter(requireContext(), styleList)
        mRvStyle.adapter = mAdapter
        mAdapter.notifyDataSetChanged()
    }

    override fun notifyDataChange() {
        if(mAdapter != null) {
            mAdapter.notifyDataSetChanged()
        }
    }

}