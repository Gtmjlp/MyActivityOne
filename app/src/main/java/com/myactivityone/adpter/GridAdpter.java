package com.myactivityone.adpter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.myactivityone.R;
import com.myactivityone.activity.SecondActivity;
import com.myactivityone.model.GridItem;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by jk on 8/14/2018.
 */

public class GridAdpter extends BaseAdapter implements Filterable
{

    Context mContext;
    ArrayList<GridItem> image;
    ArrayList<GridItem> image_org;
    private ItemFilter mFilter = new ItemFilter();
    Activity activity ;
    int count= 0;

    public GridAdpter(Context c, ArrayList<GridItem> image) {
        this.mContext = c;
        this.image = image;
        this.image_org = image;
        this.activity = (Activity) c;

    }

    @Override
    public int getCount() {
        return image.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View grid = inflater.inflate(R.layout.row_grid_item, null);

        final GridItem gridItem = image.get(position);

        ImageView bigImageView = (ImageView) grid.findViewById(R.id.mBigImage);
        TextView text_like = (TextView)grid .findViewById(R.id.text_like);
        final TextView text_count = (TextView)grid .findViewById(R.id.text_count);
        TextView text_dislike = (TextView)grid .findViewById(R.id.text_dislike);
        text_like.setTag(position);
        text_dislike.setTag(position);

        text_count.setText(String.valueOf(gridItem.getCount()));
        Picasso.with(mContext).load(gridItem.getVideo_image()).into(bigImageView);

        text_like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int likeposition = (int)v.getTag();
                count = image.get(likeposition).getCount();
                image.get(likeposition).setCount(++count);
                text_count.setText(String.valueOf(image.get(likeposition).getCount()));

            }
        });

        text_dislike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int dislikeposition = (int)v.getTag();
                count = image.get(dislikeposition).getCount();
                if (count>0){
                    image.get(dislikeposition).setCount(--count);
                    text_count.setText(String.valueOf(image.get(dislikeposition).getCount()));
                }else {

                    text_count.setText(String.valueOf(0));
                }



            }
        });

        bigImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent_secondactivity = new Intent(activity, SecondActivity.class);
                intent_secondactivity.putParcelableArrayListExtra("videourl",image);
                intent_secondactivity.putExtra("currentposition",position);
                mContext.startActivity(intent_secondactivity);

            }
        });
        return grid;
    }

    @Override
    public Filter getFilter() {
        return mFilter;
    }

    private class ItemFilter extends Filter {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {

            String filterString = constraint.toString().toLowerCase();
            FilterResults results = new FilterResults();
            ArrayList<GridItem> arrayList = image_org;

            int count = arrayList.size();
            final ArrayList<GridItem> nlist = new ArrayList<GridItem>(count);

            for (int i = 0; i < count; i++) {
                GridItem filterableString = arrayList.get(i);
                if (filterableString.getVideo_tital().toLowerCase().contains(filterString)) {
                    nlist.add(filterableString);
                }
            }
            results.values = nlist;
            results.count = nlist.size();
            return results;
        }

        @SuppressWarnings("unchecked")
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            image = (ArrayList<GridItem>) results.values;
            notifyDataSetChanged();
        }
    }
}
