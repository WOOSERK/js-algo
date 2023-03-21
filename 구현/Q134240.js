function solution(food) 
{
    const arr1 = [];

    for(let i=1; i<=food.length; i++)
    {
        const lim = Math.floor(food[i] / 2);

        let id = 0;
        for(let id=0; id < lim; id++)
            arr1.push(i);
    }

    return arr1.join("") + '0' + arr1.reverse().join("");
}