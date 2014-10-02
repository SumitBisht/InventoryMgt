package com.tss.ocean.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tss.ocean.dao.ItemDAO;
import com.tss.ocean.pojo.Item;
@Service("alarmService")
public class AlarmService implements IAlarmService
{

	@Autowired
	ItemDAO itemDAO;
	
	@Override
	public List<Item> getAlarm() {


		
		return itemDAO.getAlarm();
	}

}
