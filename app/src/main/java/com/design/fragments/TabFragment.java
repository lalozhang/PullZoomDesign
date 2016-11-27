package com.design.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.design.R;

/**
 * Created by lalo.zhang on 2016/11/27.
 */
public class TabFragment extends Fragment {

    private RecyclerView recyclerView;
    private ItemAdapter adapter;
    private String param;

    public static TabFragment newInstance(Bundle bundle){
        TabFragment tabFragment = new TabFragment();
        tabFragment.setArguments(bundle);
        return tabFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Bundle data = getArguments();
        param = data.getString("fragment_param");
        View root = inflater.inflate(R.layout.tab_fragment_layout,container,false);
        recyclerView = (RecyclerView) root.findViewById(R.id.recyclerView);
        LinearLayoutManager manager  = new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        String format = "item %s";
        String[] data = new String[100];
        for(int i = 0;i<100;i++){
            data[i] = String.format(format,i+"");
        }
        adapter  = new ItemAdapter(getContext(),data,param);
        recyclerView.setAdapter(adapter);

    }

    public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.TabViewHolder>{

        private String[] data;

        private Context context;

        private String extra;

        public ItemAdapter(Context context,String[] data,String extra){
            this.context = context;
            this.data = data;
            this.extra = extra;
        }

        @Override
        public TabViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new TabViewHolder(LayoutInflater.from(context).inflate(R.layout.item_layout,parent,false));
        }

        @Override
        public void onBindViewHolder(TabViewHolder holder, int position) {
            String item = data[position];
            holder.tvTitle.setText(extra+" "+item);
        }

        @Override
        public int getItemCount() {
            return data==null?0:data.length;
        }

        public class TabViewHolder extends RecyclerView.ViewHolder{

            private View itemView;
            private TextView tvTitle;

            public TabViewHolder(View itemView) {
                super(itemView);
                this.itemView = itemView;
                this.tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
            }

        }
    }

}
