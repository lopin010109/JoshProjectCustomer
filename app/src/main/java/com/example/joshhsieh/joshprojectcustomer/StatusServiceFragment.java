package com.example.joshhsieh.joshprojectcustomer;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.joshhsieh.joshprojectcustomer.Class.StatusService;

import java.util.ArrayList;
import java.util.List;


public class StatusServiceFragment extends Fragment {
    MainActivity mainActivity;

    @Override
    public void onCreate(Bundle saveInstanceStated) {
        super.onCreate(saveInstanceStated);
        mainActivity = (MainActivity) getActivity();

    }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.status_service_fragment,
                container, false);
        handleViews(view);
        return view;
    }

    private void handleViews(View view) {
        RecyclerView rvStatusService = view.findViewById(R.id.rvStatusService);
        rvStatusService.setLayoutManager(new LinearLayoutManager(mainActivity));

        List<StatusService> statusServiceList = getStatusServiceList();
        rvStatusService.setAdapter(new StatusServiceAdapter(mainActivity, statusServiceList));


    }



    private class StatusServiceAdapter
            extends RecyclerView.Adapter<StatusServiceAdapter.MyViewHolder> {
        private Context context;
        private List<StatusService> statusServiceList;



        StatusServiceAdapter(Context context, List<StatusService> statusServiceList) {
            this.context = context;
            this.statusServiceList = statusServiceList;

        }

        class MyViewHolder extends RecyclerView.ViewHolder {
            private ImageView imageView;
            private TextView tvItem,tvStatus;

            MyViewHolder(@NonNull View itemView) {
                super(itemView);

                imageView = itemView.findViewById(R.id.ivStatusService);
                tvItem = itemView.findViewById(R.id.tvItemService);
                tvStatus = itemView.findViewById(R.id.tvStatusService);
            }
        }


        @Override
        public int getItemCount() {
            return statusServiceList.size();
        }

        @NonNull
        @Override
        public StatusServiceAdapter.MyViewHolder onCreateViewHolder
                (@NonNull ViewGroup viewGroup, int viewType) {
            View itemView = LayoutInflater.from(context).
                    inflate(R.layout.status_service_item, viewGroup, false);

            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(@NonNull StatusServiceAdapter.
                MyViewHolder myViewHolder, int position) {
            final StatusService statusService = statusServiceList.get(position);

            myViewHolder.imageView.setImageResource(statusService.getImage());
            myViewHolder.tvItem.setText(statusService.getTvitem());
            myViewHolder.tvStatus.setText(statusService.getTvstatus());

        }



    }



    public List<StatusService> getStatusServiceList() {
        List<StatusService> statusServices = new ArrayList<>();
        statusServices.add(new StatusService(R.drawable.icon_finish,"餐點","已完成"));
        statusServices.add(new StatusService(R.drawable.icon_finish,"餐點","已完成"));
        statusServices.add(new StatusService(R.drawable.icon_playing,"餐點","已完成"));
        return statusServices;
    }

}
