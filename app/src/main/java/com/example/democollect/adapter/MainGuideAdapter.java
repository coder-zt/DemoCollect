package com.example.democollect.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.democollect.R;
import com.example.democollect.base.ForwardHelper;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * @author zhangt
 * @description:
 * @date :2020/8/18 16:38
 */
public class MainGuideAdapter extends RecyclerView.Adapter<MainGuideAdapter.GuideItem> {

    private Context mContext;
    private List<String>  mData = new ArrayList<>();

    @NonNull
    @Override
    public MainGuideAdapter.GuideItem onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View mView = inflater.inflate(R.layout.app_recycler_item_main_guide, parent, false);
        return  new GuideItem(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull MainGuideAdapter.GuideItem holder, int position) {
        holder.setData(mData, position);
    }

    @Override
    public int getItemCount() {
        if (mData != null) {
            return mData.size();
        }
        return 0;
    }

    public void setData(List<String> mGuideItems) {
       mData.clear();
        if (mGuideItems != null) {
            mData.addAll(mGuideItems);
        }
        notifyDataSetChanged();
    }

    public class GuideItem extends RecyclerView.ViewHolder {
            View mContainer;
            TextView mTvGuideItem;

        public GuideItem(@NonNull View itemView) {
            super(itemView);
            mContainer = itemView.findViewById(R.id.cl_container);
            mTvGuideItem = (TextView)itemView.findViewById(R.id.tv_guide_item);
        }

        public void setData(final List<String> data, final int position) {
            mTvGuideItem.setText(data.get(position));
            mContainer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ForwardHelper.toGuideTargetForTitle(mContext, data.get(position));
                }
            });
        }
    }
}
