package com.lou.springboot.service.impl;

import com.lou.springboot.dao.PictureDao;
import com.lou.springboot.entity.Picture;
import com.lou.springboot.service.PictureService;
import com.lou.springboot.utils.PageResult;
import com.lou.springboot.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("pictureService")
public class PictureServiceImpl implements PictureService {

    @Autowired
    private PictureDao pictureDao;

    @Override
    public PageResult getPicturePage(PageUtil pageUtil) {
        List<Picture> pictures = pictureDao.findPictures(pageUtil);
        int total = pictureDao.getTotalPictures(pageUtil);
        PageResult pageResult = new PageResult(pictures, total, pageUtil.getLimit(), pageUtil.getPage());
        return pageResult;
    }

    @Override
    public Picture queryObject(Integer id) {
        return pictureDao.findPictureById(id);
    }

    @Override
    public int save(Picture picture) {
        return pictureDao.insertPicture(picture);
    }

    @Override
    public int update(Picture picture) {
        return pictureDao.updPicture(picture);
    }

    @Override
    public int delete(Integer id) {
        return pictureDao.delPicture(id);
    }

    @Override
    public int deleteBatch(Integer[] ids) {
        return pictureDao.deleteBatch(ids);
    }

}
