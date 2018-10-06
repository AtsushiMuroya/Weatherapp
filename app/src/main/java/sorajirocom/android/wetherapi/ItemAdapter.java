package sorajirocom.android.wetherapi;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class ItemAdapter extends ArrayAdapter<Item> {
    List<Item> items;

    public ItemAdapter(Context context, int resource, List<Item> objects){
        super(context,resource,objects);
        this.items = objects;
    }
    @Override
    public int getCount(){
        return items.size();
    }
    @Override
    public Item getItem(int position){
        return items.get(position);
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent){

        final ViewHolder viewHolder;

//        class ViewHolder{
//            TextView userNameText;
//            TextView messageText;
//        }


        //final ViewHolder viewHolder;

        if(convertView != null){
            viewHolder = (ViewHolder) convertView.getTag();
        }else{
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item,parent,false);

            viewHolder = new ViewHolder();

            viewHolder.tenkiText = (TextView) convertView.findViewById(R.id.tenki);
            viewHolder.ntimeText = (TextView) convertView.findViewById(R.id.timeText);
            viewHolder.clouds = (TextView) convertView.findViewById(R.id.clouds);
            viewHolder.iconView = (ImageView) convertView.findViewById(R.id.imageView);


            convertView.setTag(viewHolder);
        }
        Item item = getItem(position);

        viewHolder.tenkiText.setText(item.getTenki());
        viewHolder.ntimeText.setText(item.getNtime());
        viewHolder.clouds.setText(String.valueOf(item.getClouds()));
//        viewHolder.icon.setText(item.getIcon());
        Glide.with(getContext()).load("http://openweathermap.org/img/w/"+ item.icon +".png").into(viewHolder.iconView);

        return convertView;
    }
    static class ViewHolder {
        TextView tenkiText;
        TextView ntimeText;
        TextView clouds;
        ImageView iconView;
        //TextView icon;
    }
}
