package com.trkj.crmproject.service;

import com.trkj.crmproject.entity.ApprecordsSon;
import com.trkj.crmproject.entity.Caigousq;

import java.util.List;

public interface ApprecordsSonService {
   public int addspzb(int app_records_id,int userId);

//   wq
   public List<ApprecordsSon> selectApprecordsByName(String username, String state);

   public List<Caigousq> selectAppCgsq();
}
