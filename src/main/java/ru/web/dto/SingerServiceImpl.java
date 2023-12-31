package ru.web.dto;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Transactional(readOnly = true)
@Service("singerService")
public class SingerServiceImpl implements SingerService{

    private SingerRepository singerRepository;

    public SingerRepository getSingerRepository() {
        return singerRepository;
    }

    @Autowired
    public void setSingerRepository(SingerRepository singerRepository) {
        this.singerRepository = singerRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Singer> findAll() {
        return Lists.newArrayList(singerRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Singer findById(Long id) {
//        System.out.println(singerRepository.findById(id).get().toString());
        return singerRepository.findById(id).get();
    }

    @Override
    public Singer save(Singer singer) {
        return singerRepository.save(singer);
    }

    @Override
    public Page<Singer> findAllPage(Pageable pageable) {
        return singerRepository.findAll(pageable);
    }

    @Transactional
    public void delete(Long id){
        singerRepository.deleteById(id);
    }


}
