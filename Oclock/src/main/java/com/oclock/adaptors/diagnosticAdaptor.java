package com.oclock.adaptors;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.oclock.R;
import com.oclock.webservice.objects.OclockDto;

import java.util.List;

/**
 * Created by yanga on 2013/06/19.
 */
public class diagnosticAdaptor extends BaseAdapter {
    private List<OclockDto> diagnostics;
    private Context context;
    public diagnosticAdaptor(Context context, List<OclockDto> diagnostics){
        this.context = context;
        this.diagnostics = diagnostics;
    }
    public void setDiagnostics(List<OclockDto> diagnostics){
        this.diagnostics = diagnostics;
    }
    @Override
    public int getCount() {
        return diagnostics.size();
    }

    @Override
    public Object getItem(int i) {
        return diagnostics.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        DefaultHolder holder = new DefaultHolder();
        OclockDto diagnostic = diagnostics.get(i);
        if (view==null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.basic_diagnostic_dto, null);
        }else {
            holder = (DefaultHolder)view.getTag();
        }
        holder.txtLabel = (TextView) view.findViewById(R.id.diagnostic_label);
        holder.txtTime  = (TextView) view.findViewById(R.id.diagnostic_time);
        holder.txtDetails = (TextView) view.findViewById(R.id.diagnostic_details);

        holder.txtLabel.setText(diagnostic.DiagnosticLabel);
        holder.txtTime.setText(diagnostic.DiagnosticTime);
        holder.txtDetails.setText(diagnostic.DiagnosticDetail);
        return view;
    }
    static class DefaultHolder {
        TextView txtLabel;
        TextView txtTime;
        TextView txtDetails;
    }
}
