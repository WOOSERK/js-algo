function solution(name, yearning, photo) 
{
    const map = new Map();
    name.forEach((v, id) => map.set(v, yearning[id]));
    
    return photo.map(v => v.reduce((acc, cur) => acc + (map.get(cur) || 0), 0));
}