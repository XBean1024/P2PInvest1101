package com.smart.bean.p2pinvest1101.fragment.tool;

import android.content.Context;
import android.view.View;

import com.smart.bean.p2pinvest1101.R;
import com.smart.bean.p2pinvest1101.fragment.tool.bean.ToolBean;
import com.smart.holder.iinterface.IViewHolder;
import com.smart.holder.iinterface.IViewHolderHelper;

import java.util.List;

/**
 * auther   : bean
 * on       : 2017/11/3
 * QQ       : 596928539
 * github   : https://github.com/Xbean1024
 * function : test 主界面的 holderhelper类
 */

public class HolderHelper implements IViewHolderHelper<ViewHolder,ToolBean> {
    public HolderHelper(OnViewHolderItemClickedListener onViewHolderItemClickedListener) {
        mOnViewHolderItemClickedListener = onViewHolderItemClickedListener;
    }

    private OnViewHolderItemClickedListener mOnViewHolderItemClickedListener;
    /**
     * 用于初始化ViewHolder
     *
     * @param viewHolder  item
     * @param convertView item View
     * @return IViewHolder
     */
    @Override
    public IViewHolder initItemViewHolder(ViewHolder viewHolder, View convertView) {
        viewHolder = new ViewHolder();
        viewHolder.mTextView = convertView.findViewById(R.id.test_item_name);
        return viewHolder;
    }

    /**
     * 用于将集合中的数据设置 item中 的每一个控件
     *
     * @param context       上下文
     * @param iBaseBeanList 数据集
     * @param viewHolder    控件容器
     * @param position      数据集中的位置
     */
    @Override
    public void bindListDataToView(Context context, List<ToolBean> iBaseBeanList, final ViewHolder viewHolder, int position) {
        viewHolder.mTextView.setText(iBaseBeanList.get(position).getName());
        viewHolder.mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = (String) viewHolder.mTextView.getText();
                mOnViewHolderItemClickedListener.onItemClicked(name);
            }
        });
    }
}
