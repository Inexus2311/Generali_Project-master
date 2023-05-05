import {expect} from 'chai'
import AddCat from "../../src/views/AddCat";

describe('Addcat' , () => {
  it('set the correct default data', () =>{
    expect(typeof AddCat.data).to.equal('function')
    const defaultData = AddCat.data()
    expect(defaultData.name).to.equal('Jerry')
    expect(defaultData.color).to.equal('0x00000')

  }
  )

})