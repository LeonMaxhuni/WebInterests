package leon.company.webapp.enums;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class InterestConverter implements AttributeConverter<InterestEnums, Integer>
{

    @Override
    public Integer convertToDatabaseColumn(InterestEnums attribute)
    {
        if (attribute == null)
            return null;
        switch (attribute)
        {
            case SPORTS:
                return 1;

            case GAMING:
                return 2;

            case FASHION:
                return 3;

            case NEWS:
                return 4;

            case DATING:
                return 5;

            case CELEBRITIES:
                return 6;

            case MUSIC:
                return 7;

            case TECHNOLOGY:
                return 8;

            case NATURE:
                return 9;

            case SCIENCE:
                return 10;

            default:
                throw new UnsupportedOperationException("Unimplemented method 'convertToDatabaseColumn'");
        }
    }

    @Override
    public InterestEnums convertToEntityAttribute(Integer dbData)
    {
        if (dbData == null)
            return null;
 
        switch (dbData)
        {
            case 1:
                return InterestEnums.SPORTS;

            case 2:
                return InterestEnums.GAMING;

            case 3:
                return InterestEnums.FASHION;

            case 4:
                return InterestEnums.NEWS;

            case 5:
                return InterestEnums.DATING;

            case 6:
                return InterestEnums.CELEBRITIES;

            case 7:
                return InterestEnums.MUSIC;

            case 8:
                return InterestEnums.TECHNOLOGY;

            case 9:
                return InterestEnums.NATURE;

            case 10:
                return InterestEnums.SCIENCE;

            default:
                throw new UnsupportedOperationException("Unimplemented method 'convertToEntityAttribute'");
        }
    }
}
