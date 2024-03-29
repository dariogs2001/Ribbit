package com.dgonzalez.ribbit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.parse.ParseObject;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by dgonzalez on 4/13/2015.
 */
public class MessageAdapter extends ArrayAdapter<ParseObject> {

    protected Context mContext;
    protected List<ParseObject> mMessages;

    public MessageAdapter(Context context, List<ParseObject> messages) {
        super(context, R.layout.message_item, messages);
        mContext = context;
        mMessages = messages;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.message_item, null);
            holder = new ViewHolder();

            holder.iconImageView = (ImageView) convertView.findViewById(R.id.messageIcon);
            holder.nameLabel = (TextView) convertView.findViewById(R.id.senderLabel);
            convertView.setTag(holder);
        }
        else
        {
            holder = (ViewHolder)convertView.getTag();
  /*          if (holder == null )
            {
                holder = new ViewHolder();

                holder.iconImageView = (ImageView) convertView.findViewById(R.id.messageIcon);
                holder.nameLabel = (TextView) convertView.findViewById(R.id.senderLabel);
            }
            */
        }

        ParseObject message = mMessages.get(position);

        if(message.getString(ParseConstants.KEY_FILE_TYPE).equals(ParseConstants.TYPE_IMAGE))
            holder.iconImageView.setImageResource(R.mipmap.ic_action_picture);
        else
            holder.iconImageView.setImageResource(R.mipmap.ic_action_play);

        holder.nameLabel.setText(message.getString(ParseConstants.KEY_SENDER_NAME));

        return convertView;
    }

    private static class ViewHolder
    {
        ImageView   iconImageView;
        TextView nameLabel;
    }

    public void refill(List<ParseObject> messages)
    {
        mMessages.clear();
        mMessages.addAll(messages);
        notifyDataSetChanged();
    }
}
