package com.example.joshhsieh.joshprojectcustomer;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.joshhsieh.joshprojectcustomer.Class.DinlingServiceMsg;

import java.util.ArrayList;
import java.util.List;

import static com.example.joshhsieh.joshprojectcustomer.Class.DinlingServiceMsg.TYPE_SENT;

public class DinlingServiceFragment extends Fragment {
    private RecyclerView rvDinlingService;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dinling_service_fab_fragment,
                container, false);

        handleViews(view);


        return view;
    }

    private void handleViews(View view) {
        rvDinlingService = view.findViewById(R.id.rvDinlingService);
        rvDinlingService.setLayoutManager(new LinearLayoutManager(getActivity()));

        List<DinlingServiceMsg> dinlingServiceMsgs = getDinlingServicesMsgs();
        rvDinlingService.setAdapter(new DinlingServiceMsgAdapter
                (getActivity(), dinlingServiceMsgs));


    }


    private class DinlingServiceMsgAdapter extends
            RecyclerView.Adapter<DinlingServiceMsgAdapter.MyViewHolder> {
        private Context context;
        private List<DinlingServiceMsg> dinlingServiceMsgs;


        private DinlingServiceMsgAdapter(Context context,
                                         List<DinlingServiceMsg> dinlingServiceMsgs) {
            this.context = context;
            this.dinlingServiceMsgs = dinlingServiceMsgs;


        }

        class MyViewHolder extends RecyclerView.ViewHolder {
            ImageView imageView;
            LinearLayout leftLayout, rightLayout;
            TextView leftMsg, rightMsg;

            MyViewHolder(@NonNull View itemView) {
                super(itemView);
                leftLayout = itemView.findViewById(R.id.left_layout_dinling);
                rightLayout = itemView.findViewById(R.id.right_layout_dinling);
                leftMsg = itemView.findViewById(R.id.left_msg_dinling);
                rightMsg = itemView.findViewById(R.id.right_msg_dinling);
                imageView = itemView.findViewById(R.id.left_dinling_imageView);

            }
        }


        @Override
        public int getItemCount() {
            return dinlingServiceMsgs.size();

        }

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
            View itemView = LayoutInflater.from(context).
                    inflate(R.layout.dinling_service_fab_item, viewGroup, false);

            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, final int position) {
            final DinlingServiceMsg dinlingServiceMsg = dinlingServiceMsgs.get(position);


            if (dinlingServiceMsg.getType() == DinlingServiceMsg.TYPE_RECEVIED) {
                myViewHolder.leftLayout.setVisibility(View.VISIBLE);
                myViewHolder.rightLayout.setVisibility(View.GONE);
                myViewHolder.imageView.setImageResource(dinlingServiceMsg.getImage());
                myViewHolder.leftMsg.setText(dinlingServiceMsg.getContent());
            } else if (dinlingServiceMsg.getType() == TYPE_SENT) {
                myViewHolder.rightLayout.setVisibility(View.VISIBLE);
                myViewHolder.leftLayout.setVisibility(View.GONE);
                myViewHolder.rightMsg.setText(dinlingServiceMsg.getContent());
            }


            myViewHolder.leftLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    switch (dinlingServiceMsg.getNumber()) {
                        case 1:
                            dinlingServiceMsgs.add
                                    (dinlingServiceMsgs.size(), new DinlingServiceMsg
                                            ("我需要A餐",
                                                    DinlingServiceMsg.TYPE_SENT,0, 0));
                            notifyItemInserted(dinlingServiceMsgs.size());

                            Toast.makeText(context, "您點了A餐", Toast.LENGTH_SHORT).show();

                            dinlingServiceMsgs.add
                                    (dinlingServiceMsgs.size(), new DinlingServiceMsg
                                            ("訂購A餐 1份",
                                                    DinlingServiceMsg.TYPE_RECEVIED,0, 4));
                            notifyItemInserted(dinlingServiceMsgs.size());
                            dinlingServiceMsgs.add
                                    (dinlingServiceMsgs.size(), new DinlingServiceMsg
                                            ("訂購A餐 2份",
                                                    DinlingServiceMsg.TYPE_RECEVIED,0, 5));
                            notifyItemInserted(dinlingServiceMsgs.size());
                            dinlingServiceMsgs.add
                                    (dinlingServiceMsgs.size(), new DinlingServiceMsg
                                            ("訂購A餐 3份",
                                                    DinlingServiceMsg.TYPE_RECEVIED,0, 6));
                            notifyItemInserted(dinlingServiceMsgs.size());

                            break;

                        case 2:
                            dinlingServiceMsgs.add
                                    (dinlingServiceMsgs.size(), new DinlingServiceMsg
                                            ("我需要B餐",
                                                    DinlingServiceMsg.TYPE_SENT,0, 0));
                            notifyItemInserted(dinlingServiceMsgs.size());
                            Toast.makeText(context, "您點了B餐", Toast.LENGTH_SHORT).show();

                            dinlingServiceMsgs.add
                                    (dinlingServiceMsgs.size(), new DinlingServiceMsg
                                            ("訂購B餐 1份",
                                                    DinlingServiceMsg.TYPE_RECEVIED,0, 7));
                            notifyItemInserted(dinlingServiceMsgs.size());
                            dinlingServiceMsgs.add
                                    (dinlingServiceMsgs.size(), new DinlingServiceMsg
                                            ("訂購B餐 2份",
                                                    DinlingServiceMsg.TYPE_RECEVIED,0, 8));
                            notifyItemInserted(dinlingServiceMsgs.size());
                            dinlingServiceMsgs.add
                                    (dinlingServiceMsgs.size(), new DinlingServiceMsg
                                            ("訂購B餐 3份",
                                                    DinlingServiceMsg.TYPE_RECEVIED,0, 9));
                            notifyItemInserted(dinlingServiceMsgs.size());
                            break;

                        case 3:
                            dinlingServiceMsgs.add
                                    (dinlingServiceMsgs.size(), new DinlingServiceMsg
                                            ("我需要C餐",
                                                    DinlingServiceMsg.TYPE_SENT,0, 0));
                            notifyItemInserted(dinlingServiceMsgs.size());
                            Toast.makeText(context, "您點了C餐", Toast.LENGTH_SHORT).show();

                            dinlingServiceMsgs.add
                                    (dinlingServiceMsgs.size(), new DinlingServiceMsg
                                            ("訂購C餐 1份",
                                                    DinlingServiceMsg.TYPE_RECEVIED,0, 10));
                            notifyItemInserted(dinlingServiceMsgs.size());
                            dinlingServiceMsgs.add
                                    (dinlingServiceMsgs.size(), new DinlingServiceMsg
                                            ("訂購C餐 2份",
                                                    DinlingServiceMsg.TYPE_RECEVIED,0, 11));
                            notifyItemInserted(dinlingServiceMsgs.size());
                            dinlingServiceMsgs.add
                                    (dinlingServiceMsgs.size(), new DinlingServiceMsg
                                            ("訂購C餐 3份",
                                                    DinlingServiceMsg.TYPE_RECEVIED,0, 12));
                            notifyItemInserted(dinlingServiceMsgs.size());
                            break;

                        case 4:
                            dinlingServiceMsgs.add
                                    (dinlingServiceMsgs.size(), new DinlingServiceMsg
                                            ("訂購A餐 1份 已送出",
                                                    DinlingServiceMsg.TYPE_SENT,0, 13));
                            notifyItemInserted(dinlingServiceMsgs.size());
                            break;
                        case 5:
                            dinlingServiceMsgs.add
                                    (dinlingServiceMsgs.size(), new DinlingServiceMsg
                                            ("訂購A餐 2份 已送出",
                                                    DinlingServiceMsg.TYPE_SENT,0, 14));
                            notifyItemInserted(dinlingServiceMsgs.size());
                            break;
                        case 6:
                            dinlingServiceMsgs.add
                                    (dinlingServiceMsgs.size(), new DinlingServiceMsg
                                            ("訂購A餐 3份 已送出",
                                                    DinlingServiceMsg.TYPE_SENT,0, 15));
                            notifyItemInserted(dinlingServiceMsgs.size());
                            break;
                        case 7:
                            dinlingServiceMsgs.add
                                    (dinlingServiceMsgs.size(), new DinlingServiceMsg
                                            ("訂購B餐 1份 已送出",
                                                    DinlingServiceMsg.TYPE_SENT,0, 16));
                            notifyItemInserted(dinlingServiceMsgs.size());
                            break;
                        case 8:
                            dinlingServiceMsgs.add
                                    (dinlingServiceMsgs.size(), new DinlingServiceMsg
                                            ("訂購B餐 2份 已送出",
                                                    DinlingServiceMsg.TYPE_SENT,0, 17));
                            notifyItemInserted(dinlingServiceMsgs.size());
                            break;
                        case 9:
                            dinlingServiceMsgs.add
                                    (dinlingServiceMsgs.size(), new DinlingServiceMsg
                                            ("訂購B餐 3份 已送出",
                                                    DinlingServiceMsg.TYPE_SENT,0, 18));
                            notifyItemInserted(dinlingServiceMsgs.size());
                            break;

                        case 10:
                            dinlingServiceMsgs.add
                                    (dinlingServiceMsgs.size(), new DinlingServiceMsg
                                            ("訂購C餐 1份 已送出",
                                                    DinlingServiceMsg.TYPE_SENT,0, 19));
                            notifyItemInserted(dinlingServiceMsgs.size());
                            break;
                        case 11:
                            dinlingServiceMsgs.add
                                    (dinlingServiceMsgs.size(), new DinlingServiceMsg
                                            ("訂購C餐 2份 已送出",
                                                    DinlingServiceMsg.TYPE_SENT,0, 20));
                            notifyItemInserted(dinlingServiceMsgs.size());
                            break;
                        case 12:
                            dinlingServiceMsgs.add
                                    (dinlingServiceMsgs.size(), new DinlingServiceMsg
                                            ("訂購C餐 3份 已送出",
                                                    DinlingServiceMsg.TYPE_SENT,0, 21));
                            notifyItemInserted(dinlingServiceMsgs.size());
                            break;

                        default:

                            break;

                    }

                    rvDinlingService.scrollToPosition(dinlingServiceMsgs.size() - 1);


                }


            });

        }
    }


    public List<DinlingServiceMsg> getDinlingServicesMsgs() {
        List<DinlingServiceMsg> dinlingServiceMsgs = new ArrayList<>();
        dinlingServiceMsgs.add(new DinlingServiceMsg
                ("您好！您需要什麼餐點呢？", DinlingServiceMsg.TYPE_RECEVIED,
                        0,0));
        dinlingServiceMsgs.add(new DinlingServiceMsg
                ("A餐 價格：300元", DinlingServiceMsg.TYPE_RECEVIED,
                        R.drawable.icon_dinling_a, 1));
        dinlingServiceMsgs.add(new DinlingServiceMsg
                ("B餐 價格：250元", DinlingServiceMsg.TYPE_RECEVIED,
                        R.drawable.icon_dinling_b, 2));
        dinlingServiceMsgs.add(new DinlingServiceMsg
                ("C餐 價格：200元", DinlingServiceMsg.TYPE_RECEVIED,
                        R.drawable.icon_dinling_c, 3));

        return dinlingServiceMsgs;
    }


}
