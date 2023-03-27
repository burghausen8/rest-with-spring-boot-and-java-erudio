package br.com.rocar.services;

import br.com.rocar.data.vo.v1.PersonVO;
import br.com.rocar.exceptions.ResourceNotFoundException;
import br.com.rocar.mapper.DozerMapper;
import br.com.rocar.models.Person;
import br.com.rocar.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    @Autowired
    PersonRepository repository;

    public List<PersonVO> findAll() {
      return DozerMapper.parseListObjects(repository.findAll(), PersonVO.class);
    }

    public PersonVO findById(Long id) {
        Person entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        return DozerMapper.parseObject(entity, PersonVO.class);
    }

    public PersonVO create(PersonVO person) {
        Person entity = repository.save(DozerMapper.parseObject(person, Person.class));

        return DozerMapper.parseObject(entity, PersonVO.class);
    }

    public PersonVO update(PersonVO person) {

        Person entity = repository.findById(person.getId())
               .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

       entity.setAddress(person.getAddress());
       entity.setName(person.getName());


       return DozerMapper.parseObject(repository.save(entity), PersonVO.class);
    }

    public void delete(Long id) {
        Person entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        repository.delete(entity);
    }

}
