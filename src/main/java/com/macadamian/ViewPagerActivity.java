package com.macadamian;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerActivity extends FragmentActivity {
    private static class Adapter extends FragmentPagerAdapter {
        private List<SimpleFragment> _fragments = new ArrayList<SimpleFragment>();

        public Adapter(FragmentManager m, List<SimpleFragment> fragments) {
            super(m);
            _fragments.addAll(fragments);
        }

        @Override
        public int getCount() {
            return _fragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return _fragments.get(position).get_title();
        }

        @Override
        public Fragment getItem(int position) {
            return _fragments.get(position);
        }
    }
    
    private static class SimpleFragment extends Fragment {
        private String _title;
        private int _contentResId;

        public SimpleFragment(String title, int contentResId) {
            _title = title;
            _contentResId = contentResId;
        }

        public String get_title() {
            return _title;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View rv = inflater.inflate(R.layout.fragment_simple_view_pager_page, container, false);
            ((TextView) rv.findViewById(R.id.fragment_simple_view_pager_page_content)).setText(_contentResId);
            return rv;
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.view_pager);
        configure_pager(make_fragments());
    }

    private List<SimpleFragment> make_fragments() {
        Resources res = getResources();
        List<SimpleFragment> rv = new ArrayList<SimpleFragment>();
        
        rv.add(new SimpleFragment(res.getString(R.string.view_pager_title_page_one), R.string.view_pager_content_page_one));
        rv.add(new SimpleFragment(res.getString(R.string.view_pager_title_page_two), R.string.view_pager_content_page_two));
        rv.add(new SimpleFragment(res.getString(R.string.view_pager_title_page_three), R.string.view_pager_content_page_three));
        
        return rv;
    }

    private void configure_pager(List<SimpleFragment> fragments) {
        ((ViewPager) findViewById(R.id.view_pager_pager)).setAdapter(
            new Adapter(getSupportFragmentManager(), fragments));
    }
}

