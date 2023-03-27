package br.com.rocar.unittests.mapper;

import br.com.rocar.data.vo.v1.PersonVO;
import br.com.rocar.mapper.DozerMapper;
import br.com.rocar.models.Person;
import br.com.rocar.unittests.mock.MockPerson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DozerConverterTest {

    MockPerson inputObject;

    @BeforeEach
    public void setUp() {
        inputObject = new MockPerson();
    }

    @Test
    public void parseEntityToVOTest() {
        PersonVO output = DozerMapper.parseObject(inputObject.mockEntity(), PersonVO.class);
        assertEquals(Long.valueOf(0L), output.getId());
        assertEquals("Name Test0", output.getName());
        assertEquals("Addres Test0", output.getAddress());
    }

    @Test
    public void parseEntityListToVOListTest() {
        List<PersonVO> outputList = DozerMapper.parseListObjects(inputObject.mockEntityList(), PersonVO.class);
        PersonVO outputZero = outputList.get(0);

        assertEquals(Long.valueOf(0L), outputZero.getId());
        assertEquals("Name Test0", outputZero.getName());
        assertEquals("Addres Test0", outputZero.getAddress());

        PersonVO outputSeven = outputList.get(7);

        assertEquals(Long.valueOf(7L), outputSeven.getId());
        assertEquals("Name Test7", outputSeven.getName());
        assertEquals("Addres Test7", outputSeven.getAddress());

        PersonVO outputTwelve = outputList.get(12);

        assertEquals(Long.valueOf(12L), outputTwelve.getId());
        assertEquals("Name Test12", outputTwelve.getName());
        assertEquals("Addres Test12", outputTwelve.getAddress());
    }

    @Test
    public void parseVOToEntityTest() {
        Person output = DozerMapper.parseObject(inputObject.mockVO(), Person.class);
        assertEquals(Long.valueOf(0L), output.getId());
        assertEquals("Name Test0", output.getName());
        assertEquals("Addres Test0", output.getAddress());
    }

    @Test
    public void parserVOListToEntityListTest() {
        List<Person> outputList = DozerMapper.parseListObjects(inputObject.mockVOList(), Person.class);
        Person outputZero = outputList.get(0);

        assertEquals(Long.valueOf(0L), outputZero.getId());
        assertEquals("Name Test0", outputZero.getName());
        assertEquals("Addres Test0", outputZero.getAddress());

        Person outputSeven = outputList.get(7);

        assertEquals(Long.valueOf(7L), outputSeven.getId());
        assertEquals("Name Test7", outputSeven.getName());
        assertEquals("Addres Test7", outputSeven.getAddress());

        Person outputTwelve = outputList.get(12);

        assertEquals(Long.valueOf(12L), outputTwelve.getId());
        assertEquals("Name Test12", outputTwelve.getName());
        assertEquals("Addres Test12", outputTwelve.getAddress());
    }
}
