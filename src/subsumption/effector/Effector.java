package subsumption.effector;
import subsumption.Wish;
/* Effektoren sind nach außen nicht sichtbar, deshalb
 * statische Factory Methode, die konkrete Effektoren produziert
 */
public abstract class Effector
{
    public abstract void accept(Wish command);
    public static Effector make(String typeName)
    {
switch (typeName)
{
case "Lamp":
    return new Lamp();
case "Chassis":
    return new Chassis();
default:
    throw new IllegalArgumentException("falscher Effektor");
}
    }
}